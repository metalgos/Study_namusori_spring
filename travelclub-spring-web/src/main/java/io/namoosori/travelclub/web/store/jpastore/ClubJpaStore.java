package io.namoosori.travelclub.web.store.jpastore;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.store.ClubStore;
import io.namoosori.travelclub.web.store.jpastore.jpo.TravelClubJpo;
import io.namoosori.travelclub.web.store.jpastore.repository.ClubRepository;
import io.namoosori.travelclub.web.util.exception.NoSuchClubException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class ClubJpaStore implements ClubStore {

    private ClubRepository clubRepository;

    public ClubJpaStore(ClubRepository clubRepository){
        this.clubRepository = clubRepository;
    }

    @Override
    public String create(TravelClub club) {
        clubRepository.save(new TravelClubJpo(club));

        return club.getId();
    }

    @Override
    public TravelClub retrieve(String clubId) {

        Optional<TravelClubJpo> clubJpo = clubRepository.findById(clubId);
        if(!clubJpo.isPresent()){
            throw new NoSuchClubException(String.format("Travel club (%s) is not found.", clubId));
        }


        return clubJpo.get().toDomain();
    }
    @Override
    public List<TravelClub> retrieveAll() {
        List<TravelClubJpo> clubJpos = clubRepository.findAll();
        //return clubJpos.stream().map(clubJpos -> clubJpos.toDomain()).collect(Collectors.toList());
        return clubJpos.stream().map(TravelClubJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<TravelClub> retrieveByName(String name) {
        //기본 삭제 검색 등은,은 id로 하지만 검색은 여러 객채로 하기떄문에 쿼리를 생성해서 사용
        //jpql이란 메소드 이름을 조합하여 쿼리 실행, select에 해당하며 @query로 사용
        List<TravelClubJpo> clubJpos = clubRepository.findAllByName(name);

        return clubJpos.stream().map(TravelClubJpo::toDomain).collect(Collectors.toList());
    }


    @Override
    public void update(TravelClub club) {
        //jpa save는 업데이트도 겸함, update는 따로 없으며 save사용
        clubRepository.save(new TravelClubJpo(club));
    }

    @Override
    public void delete(String clubId) {

        clubRepository.deleteById(clubId);
    }

    @Override
    public boolean exists(String clubId) {


        return clubRepository.existsById(clubId);

    }
}

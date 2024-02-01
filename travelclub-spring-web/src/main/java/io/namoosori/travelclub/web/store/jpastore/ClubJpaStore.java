package io.namoosori.travelclub.web.store.jpastore;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.store.ClubStore;
import io.namoosori.travelclub.web.store.jpastore.jpo.TravelClubJpo;
import io.namoosori.travelclub.web.store.jpastore.repository.ClubRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


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
        return null;
    }

    @Override
    public List<TravelClub> retrieveByName(String name) {
        return null;
    }

    @Override
    public List<TravelClub> retrieveAll() {
        return null;
    }

    @Override
    public void update(TravelClub club) {

    }

    @Override
    public void delete(String clubId) {

    }

    @Override
    public boolean exists(String clubId) {
        return false;
    }
}

package io.namoosori.travelclub.spring.store.mapstore;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.store.ClubStore;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

//빈등록시 별명 설정 가능
@Repository("clubStore")

public class ClubMapStore implements ClubStore {

    //트레블  클럽 저장 map

    private Map<String, TravelClub> clubMap;


    public ClubMapStore(){
        this.clubMap =   new LinkedHashMap<>();
    }

    @Override
    public String create(TravelClub club) {

        clubMap.put(club.getId(), club);

        return club.getId();


    }

    @Override
    public TravelClub retrieve(String clubId) {
        return clubMap.get(clubId);
    }

    @Override
    public List<TravelClub> retrieveByName(String name) {
        
        //스트림 이용
        return clubMap.values().stream().filter(club ->club.getName().equals(name)).collect(Collectors.toList()) ;
    }

    @Override
    public void update(TravelClub club) {

        clubMap.put(club.getId(), club);

    }

    @Override
    public void delete(String clubId) {

        clubMap.remove(clubId);
    }

    @Override
    public boolean exists(String clubId) {


        //방법 1 맵에서 아이디 검색
        //return clubMap.containsKey(clubId);

        //방법2 옵셔널
        return Optional.ofNullable(clubMap.get(clubId)).isPresent();
    }
}

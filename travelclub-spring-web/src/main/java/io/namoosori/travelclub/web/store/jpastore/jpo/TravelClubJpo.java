package io.namoosori.travelclub.web.store.jpastore.jpo;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="TRAVEL_CLUB")
public class TravelClubJpo {


    @Id
    private String id;
    private String name;
    private String intro;
    private Long foundationTime;

    //jpo 와 스토어 객채 변환 메소드
    public TravelClubJpo(TravelClub travelClub){
        /*
        this.id = travelClub.getId();
        this.name= travelClub.getName();
        this.intro = travelClub.getIntro();
        this.foundationTime = travelClub.getFoundationTime();

         */
        //아래 빈유틸즈 카피프로퍼티스를 쓰면 자동 객채 복사가됨
        BeanUtils.copyProperties(travelClub,this);
    }
    public TravelClub toDomain(){
        TravelClub travelClub = new TravelClub(this.name, this.intro);
        travelClub.setId(this.id);
        travelClub.setFoundationTime(this.foundationTime);
        return travelClub;
    }
}

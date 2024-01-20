package io.namoosori.travelclub.spring;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

//테스트용 메인클래스
public class TravelClubApp {
    public static void main(String[] args){

        //xml파일을 가져와서 컨텍스트 생성, xml을 가져오는 클래스패스 사용
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        String [] beanNames= context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames));

        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "Test TravelClub");
        ClubService clubService = context.getBean("clubService", ClubService.class);

        String clubId = clubService.registerClub(clubCdo);

        TravelClub foundedClub = clubService.findClubById(clubId);

        System.out.println("Club name : "  + foundedClub.getName());
        System.out.println("Club intro : "  + foundedClub.getIntro());
        System.out.println("Club foundationTime : "  + new Date( foundedClub.getFoundationTime()));

    }
}

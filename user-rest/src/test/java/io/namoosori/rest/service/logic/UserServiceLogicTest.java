package io.namoosori.rest.service.logic;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//기존 runwith 대신 스프링 부트에서 사용하는 어노테이션
@SpringBootTest
//@RequiredArgsConstructor 단위테스트에서는 사용불가
public class UserServiceLogicTest {

    @Autowired
    private UserService userService;

    private User kim;
    private User lee;

    @BeforeEach //테스트 위해 미리 데이터를 세팅하기 위한 데이터 삽입
    public void startUp(){
        this.kim = new User("Kim","kim@naver.com");
        this.lee =  new User("lee","kim@naver.com");
        this.userService.register(kim);
        this.userService.register(lee);
    }
    @Test
    public void registerTest(){

        User sample = User.sample();
        this.userService.register(sample);
        //junit5 를 이용한 테스트
        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3);
        this.userService.remove(sample.getId());
    }

    @Test
    public void find(){
        assertThat(this.userService.find(lee.getId())).isNotNull();
        assertThat(this.userService.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());

    }

    @AfterEach //단위테스트 종료전에 데이터 삭제
    public void cleanUp(){
        this.userService.remove(kim.getId());
        this.userService.remove(lee.getId());
    }
}

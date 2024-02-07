package io.namoosori.rest.service.logic;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;
import io.namoosori.rest.store.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//스프링 di주입 방법3 롬복 어노테이션 이용하기
@RequiredArgsConstructor
public class UserServiceLogic implements UserService {
    //스프링 di 인터페이스 주입 방법1 @Autowired 사용


    //final 로 지정해주면 반드시 생성자로 초기화 되는것을 이용하여 롬복으로  di주입
    private final UserStore userStore;

    //방법2 생성자를 만들면 인터페이스 구현체가 하나일경우(UserStoreLogic) 자동 주입됨
  /*  public UserServiceLogic(UserStore userStore){
        this.userStore = userStore;
   } */
    @Override
    public String register(User newUser) {
        return this.userStore.create(newUser);
    }

    @Override
    public void modify(User newUser) {
        this.userStore.update(newUser);
    }

    @Override
    public void remove(String id) {
        this.userStore.delete(id);
    }

    @Override
    public User find(String id) {
        return this.userStore.retrieve(id);
    }

    @Override
    public List<User> findAll() {
        return this.userStore.retrieveAll();
    }
}

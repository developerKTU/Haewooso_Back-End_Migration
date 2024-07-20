package com.ktu.haewooso.repository;

import com.ktu.haewooso.entity.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Test
    public void userCreateTest(){

        // TODO : Tranjection Test
        User user = new User("uuid1", "push_token1", 5);
        userRepository.save(user);

        List<User> users = userRepository.findByUuid("uuid1");
        assertThat(users.get(0).getUuid()).isEqualTo("uuid1");

    }

}
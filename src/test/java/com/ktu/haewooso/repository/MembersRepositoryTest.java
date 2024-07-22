package com.ktu.haewooso.repository;

import com.ktu.haewooso.entity.Members;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MembersRepositoryTest {

    private final UserRepository userRepository;

    @Autowired
    public MembersRepositoryTest(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Test
    public void userCreateTest(){

        // TODO : Tranjection Test
        Members members = new Members("uuid1", "push_token1", 5);
        userRepository.save(members);

        List<Members> result = userRepository.findByUuid("uuid1");
        assertThat(result.get(0).getUuid()).isEqualTo("uuid1");

    }

}
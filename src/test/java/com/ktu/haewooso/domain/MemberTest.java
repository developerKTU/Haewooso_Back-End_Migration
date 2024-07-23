package com.ktu.haewooso.domain;

import com.ktu.haewooso.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {

    private final MemberRepository memberRepository;
    @PersistenceContext
    EntityManager em;
    @Autowired
    public MemberTest(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Test
    public void memberSelectTest(){
        Member member1 = new Member("uuid_01", "push_token_01", LocalDateTime.now());
        memberRepository.save(member1);
        em.flush();
        em.clear();

        List<Member> members = memberRepository.findByMember();
        System.out.println("members = " + members);
    }
}
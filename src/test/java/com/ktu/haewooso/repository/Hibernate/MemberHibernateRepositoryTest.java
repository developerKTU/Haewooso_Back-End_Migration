package com.ktu.haewooso.repository.Hibernate;

import com.ktu.haewooso.domain.Member;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
class MemberHibernateRepositoryTest {

    private final MemberHibernateRepository memberHibernateRepository;
    private final Logger logger = LoggerFactory.getLogger(MemberHibernateRepositoryTest.class);

    @Autowired
    public MemberHibernateRepositoryTest(MemberHibernateRepository memberHibernateRepository){
        this.memberHibernateRepository = memberHibernateRepository;
    }

    @Test
    public void findAllTest(){
        // when
        List<Member> findAll = memberHibernateRepository.findAll();

        // then
        Assertions.assertThat(findAll.isEmpty()).isEqualTo(false);

        logger.info("findAll size : " + findAll.size());
    }

    @Test
    public void findByUuidTest(){
        // when
        Member findUuid = memberHibernateRepository.findByUuid("uuid01");

        // then
        Assertions.assertThat(findUuid.getUuid()).isEqualTo("uuid01");

        logger.info("findUuid = " + findUuid.getUuid());
    }

}
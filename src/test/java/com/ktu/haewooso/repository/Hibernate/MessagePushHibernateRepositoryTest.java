package com.ktu.haewooso.repository.Hibernate;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MessagePushHibernateRepositoryTest {

    private final MessagePushHibernateRepository messagePushHibernateRepository;
    private final Logger logger = LoggerFactory.getLogger(MessagePushHibernateRepositoryTest.class);

    @Autowired
    public MessagePushHibernateRepositoryTest(MessagePushHibernateRepository messagePushHibernateRepository){
        this.messagePushHibernateRepository = messagePushHibernateRepository;
    }

    @Test
    public void findByRandomPushTokenTest(){

        // when
        String randomPushToken = messagePushHibernateRepository.findByRandomPushToken("uuid02");

        //then
        assertThat(randomPushToken).isEqualTo("dKOYein2eEnggTxtYUr_3b:APA91bHP1iK2UTZ9PCu-lcbqosZsMbodxHfLKzFALzmUwocPTBMFE1EP3nJrF1PMoUOVkgSF796xoMVwtAoycUGYFVTB3eec500htoTup0JxaFQZSePxa_nVFDjpfz9IU-5jYQrQcEXd");

        logger.info("randomPushToken : " + randomPushToken);

    }

}
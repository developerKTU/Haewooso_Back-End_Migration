package com.ktu.haewooso.repository.Hibernate;

import com.ktu.haewooso.domain.SendMsg;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MessagePushHibernateRepository {

    @PersistenceContext
    private EntityManager em;

    // CREAT
    public SendMsg save(SendMsg sendMsg){
        em.persist(sendMsg);
        return sendMsg;
    }

    // DELETE
    public void delete(SendMsg sendMsg){
        em.remove(sendMsg);
    }

    // 랜덤 UUID 조회
    // WHERE : uuid, SELECT : pushToken
    public String findByRandomPushToken(String uuid){
        return em.createQuery("select m.pushToken from Member m where m.uuid not in :uuid order by random() LIMIT 1"
                , String.class)
                .setParameter("uuid", uuid)
                .getSingleResult();
    }

    // WHERE : uuid, SELECT : pushToken
    public String findByUuidOfRandomPushToken(String pushToken){
        return em.createQuery("select m.uuid from Member m where m.pushToken = :pushToken"
                , String.class)
                .setParameter("pushToken", pushToken)
                .getSingleResult();
    }

}

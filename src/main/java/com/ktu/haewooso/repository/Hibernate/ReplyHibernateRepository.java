package com.ktu.haewooso.repository.Hibernate;

import com.ktu.haewooso.domain.SendMsgReply;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyHibernateRepository {

    @PersistenceContext
    private EntityManager em;


    // CREATE
    public SendMsgReply save(SendMsgReply sendMsgReply){
        em.persist(sendMsgReply);
        return sendMsgReply;
    }

    // DELETE
    public void delete(SendMsgReply sendMsgReply){
        em.remove(sendMsgReply);
    }
}

package com.ktu.haewooso.repository.Hibernate;

import com.ktu.haewooso.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberHibernateRepository {

    @PersistenceContext
    private EntityManager em;

    // CREAT
    public Member save(Member member){
        em.persist(member);
        return member;
    }

    // DELETE
    public void delete(Member member){
        em.remove(member);
    }

    // 전체조회
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // UUID 조건 조회
    public Member findByUuid(String uuid){
        return em.find(Member.class, uuid);
    }

}

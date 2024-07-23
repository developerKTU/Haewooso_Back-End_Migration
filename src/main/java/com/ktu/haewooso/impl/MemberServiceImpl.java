package com.ktu.haewooso.impl;

import com.ktu.haewooso.domain.Member;
import com.ktu.haewooso.dto.MemberDto;
import com.ktu.haewooso.repository.MemberRepository;
import com.ktu.haewooso.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @PersistenceContext
    EntityManager em;

    @Override
    public ResponseEntity<String> memberRegister(MemberDto memberDto) {
        System.out.println("memberDto.getUuid() = " + memberDto.getUuid());
        System.out.println("memberDto.getPush_token() = " + memberDto.getPush_token());
        System.out.println("memberDto.getLast_connect_date() = " + memberDto.getLast_connect_date());
        Member member1 = new Member(memberDto.getUuid(), memberDto.getPush_token(), memberDto.getLast_connect_date());

        try{
            memberRepository.save(member1);
            em.flush();
            em.clear();
            return new ResponseEntity<String>("200", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("400", HttpStatus.BAD_REQUEST);
        }
    }
}

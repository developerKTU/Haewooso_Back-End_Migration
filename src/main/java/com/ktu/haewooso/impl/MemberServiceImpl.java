package com.ktu.haewooso.impl;

import com.ktu.haewooso.domain.Member;
import com.ktu.haewooso.dto.member.MemberCreateDto;
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

    @Override
    public ResponseEntity<String> memberRegister(MemberCreateDto memberCreateDto) {
        validateDuplicateMember(memberCreateDto);

        try{
            Member member1 = new Member(memberCreateDto.getUuid(), memberCreateDto.getPush_token(), memberCreateDto.getLast_connect_date());
            memberRepository.save(member1);
            return new ResponseEntity<String>("200", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("400", HttpStatus.BAD_REQUEST);
        }
    }

    private void validateDuplicateMember(MemberCreateDto memberCreateDto){
        Member findMember = memberRepository.findByUuid(memberCreateDto.getUuid());

        if(findMember != null){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Override
    public ResponseEntity<String> lastConnectDateUpdate(String uuid) {
        Member findMember = memberRepository.findByUuid(uuid);

        try{
            findMember.updateLastConnectDate();
            return new ResponseEntity<String>("200", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("400", HttpStatus.BAD_REQUEST);
        }
    }

}

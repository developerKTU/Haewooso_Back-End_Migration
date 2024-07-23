package com.ktu.haewooso.service;

import com.ktu.haewooso.dto.MemberDto;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    public ResponseEntity<String> memberRegister(MemberDto memberDto);
}

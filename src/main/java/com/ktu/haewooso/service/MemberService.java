package com.ktu.haewooso.service;

import com.ktu.haewooso.dto.MemberCreateDto;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    public ResponseEntity<String> memberRegister(MemberCreateDto memberCreateDto);
}

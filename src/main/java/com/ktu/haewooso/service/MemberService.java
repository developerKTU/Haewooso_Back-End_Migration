package com.ktu.haewooso.service;

import com.ktu.haewooso.dto.member.MemberCreateDto;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    public ResponseEntity<String> memberRegister(MemberCreateDto memberCreateDto);
    public ResponseEntity<String> lastConnectDateUpdate(String uuid);
}

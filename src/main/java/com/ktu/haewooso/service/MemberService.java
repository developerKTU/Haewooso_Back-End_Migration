package com.ktu.haewooso.service;

import com.ktu.haewooso.dto.MemberCreateDto;
import com.ktu.haewooso.dto.MemberUpdateDto;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    public ResponseEntity<String> memberRegister(MemberCreateDto memberCreateDto);
    public ResponseEntity<String> lastConnectDateUpdate(String uuid);
}

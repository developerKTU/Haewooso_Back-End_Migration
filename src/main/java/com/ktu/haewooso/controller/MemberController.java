package com.ktu.haewooso.controller;

import com.ktu.haewooso.dto.MemberDto;
import com.ktu.haewooso.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name="Haewooso Member API", description = "해우소 앱의 맴버 관련 API 요청을 처리하는 컨트롤러")
@RestController()
@RequestMapping("member/")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @Operation(summary="멤버 등록 API", description="신규 유저 등록 API")
    @PostMapping("api/newmember")
    public String memberRegister(@RequestBody MemberDto memberDto){
        return memberService.memberRegister(memberDto).getBody();
    }
}

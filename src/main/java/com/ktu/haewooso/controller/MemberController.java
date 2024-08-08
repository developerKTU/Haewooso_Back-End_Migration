package com.ktu.haewooso.controller;

import com.ktu.haewooso.dto.member.MemberCreateDto;
import com.ktu.haewooso.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name="Haewooso Member API", description = "해우소 앱의 맴버 관련 API 요청을 처리하는 Controller")
@RestController()
@RequestMapping("member/")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @Operation(summary="멤버 등록 API", description="**신규 유저 등록 API**\n\n_<<uuid : 회원ID>>_\n\n" +
                                        "_<<push_token : push 알림을 받을 고유 토큰값>>_\n\n" +
                                        "_<<last_connect_date : 최근 접속 일자>>_")
    @PostMapping("api/v1/newmember")
    public String memberRegister(@RequestBody @Valid MemberCreateDto memberCreateDto){
        return memberService.memberRegister(memberCreateDto).getBody();
    }

    @Operation(summary = "멤버 수정 API", description = "")
    @PutMapping("api/v1/connectdateupdate/{uuid}")
    public String lastConnectDateUpdate(@PathVariable("uuid") String uuid){
        return memberService.lastConnectDateUpdate(uuid).getBody();
    }

}

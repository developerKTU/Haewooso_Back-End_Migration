package com.ktu.haewooso.controller;

import com.ktu.haewooso.dto.board.MessageBoardDto;
import com.ktu.haewooso.dto.board.MessageReplyDto;
import com.ktu.haewooso.repository.MessagePushRepository;
import com.ktu.haewooso.service.MessageBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Haewooso Message Board API", description = "해우소 앱의 보낸 메시지 조회 및 답변 달기 기능 API 구현 컨트롤러")
@RestController
@RequestMapping("board/")
public class MessageBoardController {

    private final MessageBoardService messageBoardService;
    @Autowired
    public MessageBoardController(MessageBoardService messageBoardService){
        this.messageBoardService = messageBoardService;
    }

    @Operation(summary = "메인화면 푸시 알림 조회 API", description = "사용자들이 보낸 푸시알림 및 답변들을 조회하는 API")
    @GetMapping("api/v1/getmainboardlist")
    public List<MessageBoardDto> getSendMessageList(){
        return messageBoardService.getMainBoardList();
    }

    @Operation(summary = "푸시알림 답장 기능 API", description = "사용자가 보낸 푸시알림에 답장 기능 구현 API")
    @PostMapping("api/v1/createreply")
    public String createReply(@RequestBody MessageReplyDto messageReplyDto){
        return messageBoardService.createReply(messageReplyDto).getBody();
    }

}

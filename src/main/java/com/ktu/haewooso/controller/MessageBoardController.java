package com.ktu.haewooso.controller;

import com.ktu.haewooso.dto.board.MessageBoardDto;
import com.ktu.haewooso.dto.board.MessageReplyDto;
import com.ktu.haewooso.repository.MessagePushRepository;
import com.ktu.haewooso.service.MessageBoardService;
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

    @GetMapping("api/v1/getmainboardlist")
    public List<MessageBoardDto> getSendMessageList(){
        return messageBoardService.getMainBoardList();
    }

    @PostMapping("api/v1/createreply")
    public String createReply(@RequestBody MessageReplyDto messageReplyDto){
        return messageBoardService.createReply(messageReplyDto).getBody();
    }

}

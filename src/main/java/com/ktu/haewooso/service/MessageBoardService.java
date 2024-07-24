package com.ktu.haewooso.service;

import com.ktu.haewooso.dto.board.MessageBoardDto;
import com.ktu.haewooso.dto.board.MessageReplyDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageBoardService {
    public ResponseEntity<String> createReply(MessageReplyDto messageReplyDto);

    public List<MessageBoardDto> getMainBoardList();

}

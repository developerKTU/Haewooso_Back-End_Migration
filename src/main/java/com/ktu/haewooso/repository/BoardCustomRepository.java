package com.ktu.haewooso.repository;

import com.ktu.haewooso.dto.board.MessageBoardDto;

import java.util.List;

public interface BoardCustomRepository {
    List<MessageBoardDto> getMainBoardList();
}

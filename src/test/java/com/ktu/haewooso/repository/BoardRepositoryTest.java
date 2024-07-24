package com.ktu.haewooso.repository;

import com.ktu.haewooso.dto.board.MessageBoardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BoardRepositoryTest {

    private final BoardRepository boardRepository;
    @Autowired
    public BoardRepositoryTest(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Test
    public void customRepoTest(){
        List<MessageBoardDto> mainBoardList = boardRepository.getMainBoardList();
        /*
        for (MessageBoardDto messageBoardDto : mainBoardList) {

        }
         */

        assertThat(mainBoardList.size()).isEqualTo(10);

    }

}
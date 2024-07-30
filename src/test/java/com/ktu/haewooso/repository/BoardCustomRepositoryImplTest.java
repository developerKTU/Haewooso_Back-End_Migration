package com.ktu.haewooso.repository;

import com.ktu.haewooso.dto.board.MessageBoardDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BoardCustomRepositoryImplTest {

    private final BoardCustomRepository boardCustomRepository;
    private final Logger logger = LoggerFactory.getLogger(BoardCustomRepositoryImplTest.class);

    @Autowired
    public BoardCustomRepositoryImplTest(@Qualifier("boardCustomRepositoryImpl") BoardCustomRepository boardCustomRepository){
        this.boardCustomRepository = boardCustomRepository;
    }

    @Test
    public void mybatisTest(){
        // when
        List<MessageBoardDto> result = boardCustomRepository.getMainBoardList();

        // then
        assertThat(result.isEmpty()).isEqualTo(false);
        logger.info("result size = " + result.size());

    }

}
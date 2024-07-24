package com.ktu.haewooso.repository;

import com.ktu.haewooso.dto.board.MessageBoardDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardCustomRepositoryImpl implements BoardCustomRepository {

    private final SqlSessionTemplate mybatis;

    @Autowired
    public BoardCustomRepositoryImpl(SqlSessionTemplate mybatis){
        this.mybatis = mybatis;
    }


    @Override
    public List<MessageBoardDto> getMainBoardList() {

        return mybatis.selectList("BoardCustomRepository.getMainBoardList");
    }
}

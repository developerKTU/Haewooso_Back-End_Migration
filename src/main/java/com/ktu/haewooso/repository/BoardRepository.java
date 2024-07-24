package com.ktu.haewooso.repository;

import com.ktu.haewooso.domain.SendMsg;
import com.ktu.haewooso.dto.board.MessageBoardDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<SendMsg, String>, BoardCustomRepository {

}

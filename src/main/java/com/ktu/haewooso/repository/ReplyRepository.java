package com.ktu.haewooso.repository;

import com.ktu.haewooso.domain.SendMsgReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<SendMsgReply, Integer> {
}

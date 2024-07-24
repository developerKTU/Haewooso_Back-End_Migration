package com.ktu.haewooso.impl;

import com.ktu.haewooso.domain.SendMsgReply;
import com.ktu.haewooso.dto.board.MessageBoardDto;
import com.ktu.haewooso.dto.board.MessageReplyDto;
import com.ktu.haewooso.repository.BoardCustomRepository;
import com.ktu.haewooso.repository.BoardRepository;
import com.ktu.haewooso.repository.ReplyRepository;
import com.ktu.haewooso.service.MessageBoardService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MessageBoardServiceImpl implements MessageBoardService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;
    private final EntityManager em;
    @Autowired
    public MessageBoardServiceImpl(ReplyRepository replyRepository, BoardRepository boardRepository, EntityManager em){
        this.replyRepository = replyRepository;
        this.boardRepository = boardRepository;
        this.em = em;
    }

    @Override
    public ResponseEntity<String> createReply(MessageReplyDto messageReplyDto) {
        try{
            SendMsgReply sendMsgReply = SendMsgReply.builder()
                    .sendBoardSno(messageReplyDto.getSendBoardSno())
                    .replier(messageReplyDto.getReplier())
                    .replyContents(messageReplyDto.getReplyContents())
                    .replyRegistDate(LocalDateTime.now())
                    .build();
            replyRepository.save(sendMsgReply);
            em.flush();
            em.clear();
            return new ResponseEntity<String>("200", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("400", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<MessageBoardDto> getMainBoardList() {
        List<MessageBoardDto> result = boardRepository.getMainBoardList();
        return result;
    }
}

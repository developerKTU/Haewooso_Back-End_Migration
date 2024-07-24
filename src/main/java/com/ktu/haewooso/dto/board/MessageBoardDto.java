package com.ktu.haewooso.dto.board;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageBoardDto {
    private int sendBoardSno;
    private String sendUuid;
    private String receiveUuid;
    private String title;
    private String description;
    private int sendBoardReplyCount;
    private char replyCompleteYn;
    private LocalDateTime sendDate;
    private char replyViewYn;

    private String replier;
    private String replyContents;
    private LocalDateTime replyRegistDate;
}

package com.ktu.haewooso.dto.pushMessage;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessagePushDto {

    @NotNull
    private String sendUuid;

    @NotNull
    private String title;

    @NotNull
    private String description;

    private String receiveUuid;
    private int sendBoardReplyCount;
    private char replyCompleteYn;

    @NotNull
    private LocalDateTime sendDate;

    private LocalDateTime receiveDate;
    private char replyViewYn;
    private char mainViewYn;
    private char replyPossibleYn;

}

package com.ktu.haewooso.dto.board;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageReplyDto {

    @NotNull
    private int sendBoardSno;

    @NotNull
    private String replier;

    @NotNull
    private String replyContents;

}

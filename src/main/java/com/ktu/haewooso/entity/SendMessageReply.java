package com.ktu.haewooso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SendMessageReply {

    @Id
    private int send_board_sno;
    private String reply_contetns;

    public SendMessageReply(String reply_contents){
        this.reply_contetns = reply_contents;
    }

}

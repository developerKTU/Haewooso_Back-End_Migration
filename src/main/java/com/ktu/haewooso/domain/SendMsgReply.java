package com.ktu.haewooso.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SendMsgReply {

    @Id @Column(name = "reply_sno")
    private int replySno;

    private String replier;
    private String title;
    private LocalDateTime replyRegisterDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "send_board_sno")
    private SendMsg sendMsg;

}

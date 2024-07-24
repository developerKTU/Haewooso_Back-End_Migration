package com.ktu.haewooso.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(name = "send_msg_reply_SEQ_GENERATOR", sequenceName = "send_msg_reply_seq", allocationSize = 1)
public class SendMsgReply {

    @Id @Column(name = "reply_sno")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "send_msg_reply_SEQ_GENERATOR")
    private int replySno;

    private int sendBoardSno;
    private String replier;
    private String replyContents;
    private LocalDateTime replyRegistDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sendBoardSno", referencedColumnName = "send_board_sno", insertable = false, updatable = false)
    private SendMsg sendMsg;

    @Builder
    public SendMsgReply(int sendBoardSno, String replier, String replyContents, LocalDateTime replyRegistDate){
        this.sendBoardSno = sendBoardSno;
        this.replier = replier;
        this.replyContents = replyContents;
        this.replyRegistDate = replyRegistDate;
    }

}

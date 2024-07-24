package com.ktu.haewooso.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// JPA 시퀀스에서는 50씩 증가하도록 설정되어 있어 시퀀스가 1씩 증가하도록 설정
@SequenceGenerator(name = "send_msg_SEQ_GENERATOR", sequenceName = "send_msg_seq", allocationSize = 1)
public class SendMsg {

    @Id @Column(name = "send_board_sno")
    // 위의 설정한 시퀀스 제너레이터 참조
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "send_msg_SEQ_GENERATOR")
    private int sendBoardSno;

    private String sendUuid;
    private String receiveUuid;
    private String title;
    private String description;
    private int sendBoardReplyCount;
    private char replyCompleteYn;
    private LocalDateTime sendDate;
    private LocalDateTime receiveDate;
    private char replyViewYn;
    private char mainViewYn;
    private char replyPossibleYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sendUuid", referencedColumnName = "uuid", insertable = false, updatable = false)
    Member member;

    @JsonIgnore
    @OneToMany(mappedBy = "sendMsg")
    List<SendMsgReply> SendMsgReplies = new ArrayList<SendMsgReply>();

    @Builder
    public SendMsg(String sendUuid, String receiveUuid, String title, String description,
                   int sendBoardReplyCount, char replyCompleteYn, LocalDateTime sendDate,
                   LocalDateTime receiveDate, char replyViewYn, char mainViewYn, char replyPossibleYn){
        this.sendUuid = sendUuid; this.receiveUuid = receiveUuid; this.title = title; this.description =description;
        this.sendBoardReplyCount = sendBoardReplyCount; this.replyCompleteYn = replyCompleteYn; this.sendDate = sendDate;
        this.receiveDate = receiveDate; this.replyViewYn = replyViewYn; this.mainViewYn = mainViewYn; this.replyPossibleYn = replyPossibleYn;
    }

    @Override
    public String toString(){
        return " sendBoardSno" + sendBoardSno + " sendUuid = " + sendUuid + " receiveUuid = " + receiveUuid + " title = " + title + " description = "
                + description + " sendBoardReplyCount = " + sendBoardReplyCount + " replyCompleteYn = " + replyCompleteYn
                + " sendDate = " + sendDate + " receiveDate = " + receiveDate + " replyViewYn = " + replyViewYn
                + " mainViewYn = " + mainViewYn + " replyPossibleYn = " + replyPossibleYn;
    }

}

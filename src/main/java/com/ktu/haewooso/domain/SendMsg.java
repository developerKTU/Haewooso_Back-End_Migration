package com.ktu.haewooso.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SendMsg {

    @Id @Column(name = "sendBoardSno")
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
    @JoinColumn(name = "member_id")
    Member member;

    @JsonIgnore
    @OneToMany(mappedBy = "sendMsg")
    List<SendMsgReply> SendMsgReplies = new ArrayList<SendMsgReply>();

}

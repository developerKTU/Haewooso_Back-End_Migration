package com.ktu.haewooso.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SendMessage {

    @Id
    private String sender_uuid;

    @Id
    private int board_sno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uuid")
    User user;

    @OneToMany(mappedBy = "sendMessage",cascade = CascadeType.ALL, orphanRemoval = true)
    List<SendMessageReply> sendMessageReply;

}

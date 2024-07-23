package com.ktu.haewooso.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @Column(name = "uuid")
    private String uuid;
    private String pushToken;
    private final int sendCount = 5;
    private LocalDateTime lastConnectDate;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<SendMsg> sendMsgs = new ArrayList<SendMsg>();

    public Member(String uuid, String pushToken, LocalDateTime lastConnectDate){
        this.uuid = uuid;
        this.pushToken = pushToken;
        this.lastConnectDate = lastConnectDate;
    }

}

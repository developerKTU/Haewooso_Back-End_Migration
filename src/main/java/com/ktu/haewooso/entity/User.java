package com.ktu.haewooso.entity;

import com.ktu.haewooso.entity.auditing.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTime implements Persistable<String> {

    @Id
    private String uuid;
    private String push_token;
    private int send_count;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SendMessage> sendMessage = new ArrayList<>();

    @Override
    public String getId() {
        return this.uuid;
    }

    @Override
    public boolean isNew() {
        return getCreatedDate() == null;
    }

    public User(String uuid, String push_token, int send_count){
        this.uuid = uuid;
        this.push_token = push_token;
        this.send_count = send_count;
    }
}

package com.ktu.haewooso.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDto {
    private String uuid;
    private String push_token;
    private LocalDateTime last_connect_date;
}

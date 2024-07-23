package com.ktu.haewooso.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberCreateDto {

    @NotNull
    private String uuid;
    @NotNull
    private String push_token;

    private LocalDateTime last_connect_date;
}

package com.ktu.haewooso.dto.member;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberUpdateDto {

    @NotNull
    private String uuid;

}

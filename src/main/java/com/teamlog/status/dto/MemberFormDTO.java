package com.teamlog.status.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberFormDTO {
    private Long id;
    private String name;
    private String status;
    private String message;
}
package com.teamlog.status.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateDTO {
    private Long id;
    private String status;
    private String message;
}
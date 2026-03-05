package com.teamlog.status.model;

import lombok.Getter;

@Getter
public enum Status {
    WORK("업무 중"),
    MEETING("회의 중"),
    OUT("외출"),
    OFF("퇴근");

    private final String description;

    Status(String description) {
        this.description = description;
    }
}
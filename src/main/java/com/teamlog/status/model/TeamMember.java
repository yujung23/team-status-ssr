package com.teamlog.status.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class TeamMember {
    private Long id;              // 구분자
    private String name;          // 팀원 이름
    private Status status;        // Enum 타입 사용
    private String message;       // 메모/한마디
    private LocalDateTime lastUpdated; // 마지막 상태 변경 시간

    public void updateStatus(Status newStatus, String newMessage) {
        this.status = newStatus;
        this.message = newMessage;
        this.lastUpdated = LocalDateTime.now();
    }
}
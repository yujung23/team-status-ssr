package com.teamlog.status.service;

import com.teamlog.status.dao.TeamStatusDAO;
import com.teamlog.status.dto.MemberFormDTO;
import com.teamlog.status.dto.UpdateDTO;
import com.teamlog.status.model.Status;
import com.teamlog.status.model.TeamMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TeamStatusService {

    private final TeamStatusDAO dao;

    // 1. 등록 로직
    public void addMember(MemberFormDTO dto) {
        TeamMember newMember = new TeamMember(
                null,
                dto.getName(),
                Status.valueOf(dto.getStatus()), // String -> Enum 변환
                dto.getMessage(),
                LocalDateTime.now()
        );
        dao.save(newMember);
    }

    // 2. 조회 로직
    public TeamMember getMemberById(Long id) {
        return dao.findById(id);
    }

    // 3. 수정 로직
    public void updateMemberStatus(UpdateDTO dto) {
        TeamMember member = dao.findById(dto.getId());
        if (member != null) {
            Status newStatus = Status.valueOf(dto.getStatus()); // String -> Enum 변환
            member.updateStatus(newStatus, dto.getMessage());
        }
    }
}
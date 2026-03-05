package com.teamlog.status.service;

import com.teamlog.status.dao.TeamStatusDAO;
import com.teamlog.status.dto.MemberFormDTO;
import com.teamlog.status.model.Status;
import com.teamlog.status.model.TeamMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamStatusService {

    private final TeamStatusDAO teamStatusDAO;

    // 1. 등록 로직
    public void addMember(MemberFormDTO dto) {
        TeamMember newMember = new TeamMember(
                null,
                dto.getName(),
                Status.valueOf(dto.getStatus()), // String -> Enum 변환
                dto.getMessage(),
                LocalDateTime.now()
        );
        teamStatusDAO.save(newMember);
    }

    // 2. 단건 조회 로직
    public TeamMember getMemberById(Long id) {
        return teamStatusDAO.findById(id);
    }

    // 3. 수정 로직
    public void updateMemberStatus(MemberFormDTO dto) {
        TeamMember member = teamStatusDAO.findById(dto.getId());
        if (member != null) {
            Status newStatus = Status.valueOf(dto.getStatus()); // String -> Enum 변환
            member.updateStatus(newStatus, dto.getMessage());
        }
    }

    // 4. 전체 팀원 조회
    public List<TeamMember> getAllMembers() {
        return teamStatusDAO.findAll();
    }

    // 5. 특정 팀원 삭제
    public void deleteMember(Long id) {
        teamStatusDAO.deleteById(id);
    }
}
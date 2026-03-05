package com.teamlog.status.service;

import com.teamlog.status.dao.TeamStatusDAO;
import com.teamlog.status.model.TeamMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamStatusService {

    private final TeamStatusDAO teamStatusDAO;

    // 전체 팀원 조회
    public List<TeamMember> getAllMembers() {
        return teamStatusDAO.findAll();
    }

    // 특정 팀원 삭제
    public void deleteMember(Long id) {
        teamStatusDAO.deleteById(id);
    }
}
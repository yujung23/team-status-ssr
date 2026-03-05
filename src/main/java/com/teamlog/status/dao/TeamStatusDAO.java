package com.teamlog.status.dao;

import com.teamlog.status.model.TeamMember;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamStatusDAO {
    private final List<TeamMember> store = new ArrayList<>();
    private static long sequence = 0L;

    // 1. 등록 (ID 자동 발급)
    public TeamMember save(TeamMember member) {
        member.setId(++sequence);
        store.add(member);
        return member;
    }

    // 2. 단건 조회 (수정할 때 필요)
    public TeamMember findById(Long id) {
        return store.stream()
                .filter(member -> member.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // 3. 전체 조회 (A님이 사용할 메서드)
    public List<TeamMember> findAll() {
        return new ArrayList<>(store);
    }
}
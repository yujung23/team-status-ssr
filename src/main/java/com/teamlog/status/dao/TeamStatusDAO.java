package com.teamlog.status.dao;

import com.teamlog.status.model.Status;
import com.teamlog.status.model.TeamMember;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamStatusDAO {

    private static final List<TeamMember> members = new ArrayList<>();

    // ID 자동 발급
    private static long sequence = 5L;

    // 초기 더미 데이터
    static {
        members.add(new TeamMember(1L, "박지은", Status.WORK, "백엔드 컨트롤러 설계 중", LocalDateTime.now()));
        members.add(new TeamMember(2L, "김유정", Status.MEETING, "Thymeleaf 화면 레이아웃 회의 참석 중", LocalDateTime.now().minusMinutes(30)));
        members.add(new TeamMember(3L, "남민영", Status.WORK, "DAO 더미 데이터 구조 세팅 및 테스트", LocalDateTime.now().minusHours(1)));
        members.add(new TeamMember(4L, "류경록", Status.OUT, "외부 세미나 참석 (오후 5시 복귀 예정)", LocalDateTime.now().minusHours(2)));
        members.add(new TeamMember(5L, "유정호", Status.OFF, "오전 반차 사용, 오후 2시 출근합니다.", LocalDateTime.now().minusDays(1)));
    }

    // 등록 로직
    public TeamMember save(TeamMember member) {
        member.setId(++sequence);
        members.add(member);
        return member;
    }

    // 단건 조회 로직 -> 수정에 사용
    public TeamMember findById(Long id) {
        return members.stream()
                .filter(member -> member.getId().equals(id))
                .findFirst()
                .orElse(null); // 못 찾으면 null 반환
    }

    // 전체 조회 로직
    public List<TeamMember> findAll() {
        return members;
    }

    // 삭제 로직
    public void deleteById(Long id) {
        members.removeIf(member -> member.getId().equals(id));
    }
}
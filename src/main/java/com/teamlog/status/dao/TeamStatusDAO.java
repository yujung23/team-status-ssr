package com.teamlog.status.dao;

import com.teamlog.status.model.Status;
import com.teamlog.status.model.TeamMember;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TeamStatusDAO {
    // 메모리에 데이터 저장 (서버가 켜져 있는 동안 유지)
    private static final List<TeamMember> members = new ArrayList<>();

    // 클래스가 로드될 때 초기 더미 데이터 5명 세팅
    static {
        members.add(new TeamMember(1L, "박지은", Status.WORK, "백엔드 컨트롤러 설계 중", LocalDateTime.now()));
        members.add(new TeamMember(2L, "김유정", Status.MEETING, "Thymeleaf 화면 레이아웃 회의 참석 중", LocalDateTime.now().minusMinutes(30)));
        members.add(new TeamMember(3L, "남민영", Status.WORK, "DAO 더미 데이터 구조 세팅 및 테스트", LocalDateTime.now().minusHours(1)));
        members.add(new TeamMember(4L, "류경록", Status.OUT, "외부 세미나 참석 (오후 5시 복귀 예정)", LocalDateTime.now().minusHours(2)));
        members.add(new TeamMember(5L, "유정호", Status.OFF, "오전 반차 사용, 오후 2시 출근합니다.", LocalDateTime.now().minusDays(1)));
    }

    // 전체 팀원 목록 조회
    public List<TeamMember> findAll() {
        return members;
    }

    // 특정 팀원 삭제
    public void deleteById(Long id) {
        // 전달받은 id와 일치하는 멤버를 리스트에서 제거
        members.removeIf(member -> member.getId().equals(id));
    }
}
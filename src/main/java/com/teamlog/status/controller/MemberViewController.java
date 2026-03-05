package com.teamlog.status.controller;

import com.teamlog.status.service.TeamStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberViewController {

    private final TeamStatusService teamStatusService;

    // 대시보드 화면 렌더링 (조회)
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // 서비스에서 데이터를 가져와 Model에 담아 View로 전달
        model.addAttribute("members", teamStatusService.getAllMembers());
        return "dashboard"; // templates/dashboard.html을 찾아감
    }

    // 특정 멤버 삭제 액션
    @PostMapping("/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        // 서비스의 삭제 로직 호출
        teamStatusService.deleteMember(id);

        // 삭제 완료 후 다시 대시보드 화면으로 리다이렉트 (새로운 GET 요청 발생)
        // DispatcherServlet이 브라우저에게 /dashboard로 다시 접속하도록 하여 화면을 최신 상태로 새로고침 해줌
        return "redirect:/dashboard";
    }
}
package com.teamlog.status.controller;

import com.teamlog.status.dto.MemberFormDTO;
import com.teamlog.status.model.Status;
import com.teamlog.status.model.TeamMember;
import com.teamlog.status.service.TeamStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberFormController {

    private final TeamStatusService teamStatusService;

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("formDto", new MemberFormDTO());
        model.addAttribute("statuses", Status.values());
        return "add-status";
    }

    @PostMapping("/add")
    public String addMember(@ModelAttribute MemberFormDTO formDto) {
        teamStatusService.addMember(formDto);
        return "redirect:/dashboard";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        TeamMember member = teamStatusService.getMemberById(id);

        MemberFormDTO dto = new MemberFormDTO();
        dto.setId(member.getId());
        dto.setStatus(member.getStatus().name());
        dto.setMessage(member.getMessage());

        model.addAttribute("formDto", dto);
        model.addAttribute("member", member);
        model.addAttribute("statuses", Status.values());

        return "edit-status";
    }

    @PostMapping("/edit")
    public String editMember(@ModelAttribute MemberFormDTO dto) {
        teamStatusService.updateMemberStatus(dto);
        return "redirect:/dashboard";
    }
}
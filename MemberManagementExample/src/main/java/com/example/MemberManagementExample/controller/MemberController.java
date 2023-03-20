package com.example.MemberManagementExample.controller;

import com.example.MemberManagementExample.domain.Member;
import com.example.MemberManagementExample.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMembersForm";
    }

    @PostMapping("/members/new")
    public String caeate(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());

        memberService.join(member);
        return "redirect:/";
    }

}

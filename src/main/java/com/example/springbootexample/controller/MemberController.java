package com.example.springbootexample.controller;

import com.example.springbootexample.dto.MemberForm;
import com.example.springbootexample.entity.Article;
import com.example.springbootexample.entity.Member;
import com.example.springbootexample.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String newMemberForm() { return "members/new"; }

    @PostMapping("/members/join")
    public String createMember(MemberForm form) {
        System.out.println(form.toString());
        // DTO를 엔티티로 변환
        Member member = form.toEntity();
        System.out.println(member.toString());
        // 리파지토리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());
        return "";
    }
}

package com.example.MemberManagementExample;

import com.example.MemberManagementExample.repository.MemberRepository;
import com.example.MemberManagementExample.repository.MemoryMemberRepository;
import com.example.MemberManagementExample.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
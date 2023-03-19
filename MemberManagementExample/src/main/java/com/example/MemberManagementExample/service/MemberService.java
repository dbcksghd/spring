package com.example.MemberManagementExample.service;

import com.example.MemberManagementExample.domain.Member;
import com.example.MemberManagementExample.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    public Long join(Member member) {
        //중복 제거
        memoryMemberRepository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        memoryMemberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memoryMemberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memoryMemberRepository.findById(memberId);
    }
}

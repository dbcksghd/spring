package com.example.MemberManagementExample.repository;

import com.example.MemberManagementExample.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void AfterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("yoochanhong");

        memoryMemberRepository.save(member);
        Member result = memoryMemberRepository.findById(member.getId()).get();

        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("what1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("what2");
        memoryMemberRepository.save(member2);
        Member result = memoryMemberRepository.findByName("what1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("what1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("what2");
        memoryMemberRepository.save(member2);

        List<Member> result = memoryMemberRepository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}

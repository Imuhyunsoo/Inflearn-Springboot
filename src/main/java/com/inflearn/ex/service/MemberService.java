package com.inflearn.ex.service;

import com.inflearn.ex.controller.domain.Member;
import com.inflearn.ex.repository.MemberRepository;
import com.inflearn.ex.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member) {
        // 조건 1 같은 이름을 가진 중복회원은 가져서는 안된다.

        /* 방법 1 Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }); */

        // 방법 2
        validateDuplicateMember(member);   // 중복 회원 검증

        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존개하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {

        return memberRepository.findById(memberId);
    }
}
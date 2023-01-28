package com.inflearn.ex;

import com.inflearn.ex.repository.MemberRepository;
import com.inflearn.ex.repository.MemoryMemberRepository;
import com.inflearn.ex.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

package com.sns.member.service;

import com.sns.member.dto.RegisterMemberCommand;
import com.sns.member.entity.Member;
import com.sns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriterService {

    final private MemberRepository memberRepository;


    public Member register(RegisterMemberCommand command) {
        /*
         * 회원정보 등록 (email, nickname, birthday) 등록
         */
        var member = Member.builder()
                .nickname(command.nickanme())
                .email(command.email())
                .birthday(command.birthday())
                .build();
        return memberRepository.save(member);
    }

}

package com.sns.domain.member.service;

import com.sns.domain.member.repository.MemberRepository;
import com.sns.domain.member.dto.RegisterMemberCommand;
import com.sns.domain.member.entity.Member;
import com.sns.domain.member.entity.MemberNickNameHistory;
import com.sns.domain.member.repository.MemberNickNameHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberWriterService {

    final private MemberRepository memberRepository;
    final private MemberNickNameHistoryRepository memberNickNameHistoryRepository;


    // inner 함수 호출 시 Transaction이 걸리지 않음 (Proxy Pattern)
    @Transactional
    public Member create(RegisterMemberCommand command) {
        /*
         * 회원정보 등록 (email, nickname, birthday) 등록
         */
        var member = Member.builder()
                .nickname(command.nickanme())
                .email(command.email())
                .birthday(command.birthday())
                .build();
        var savedMember = memberRepository.save(member);
        saveMemberNickNameHistory(savedMember);
        return savedMember;
    }

    public void chagneNickname(Long memberId, String nickname) {
        var member = memberRepository.findById(memberId).orElseThrow();
        member.changeNickName(nickname);

        memberRepository.save(member);

        saveMemberNickNameHistory(member);

        /* Member 변경내역을 저장한다. */
    }

    private void saveMemberNickNameHistory(Member member) {
        var history = MemberNickNameHistory.builder()
                .memberId(member.getId())
                .nickname(member.getNickname())
                .build();

        memberNickNameHistoryRepository.save(history);
    }


}

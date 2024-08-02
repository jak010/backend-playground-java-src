package com.sns.domain.member.service;

import com.sns.domain.member.dto.MemberDto;
import com.sns.domain.member.repository.MemberRepository;
import com.sns.domain.member.dto.MemberNickNameHistoryDto;
import com.sns.domain.member.entity.Member;
import com.sns.domain.member.entity.MemberNickNameHistory;
import com.sns.domain.member.repository.MemberNickNameHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberReadService {

    final private MemberRepository memberRepository;
    final private MemberNickNameHistoryRepository memberNickNameHistoryRepository;

    public MemberDto getMember(Long id) {
        var member = memberRepository.findById(id).orElseThrow();
        return toDto(member);
    }

    public List<MemberNickNameHistoryDto> getNickNameHistories(Long memberId) {
        // xxx: MemberHistory 관련 기능을 "Member"에서 제공하는 것에 주목
        return memberNickNameHistoryRepository.findAllByMemberId(memberId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    public List<MemberDto> getMembers(List<Long> ids) {
        var members = memberRepository.findAllByIdIn(ids);
        return members.stream().map(this::toDto).toList();
    }


    public MemberDto toDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getEmail(),
                member.getNickname(),
                member.getBirthday()
        );
    }

    public MemberNickNameHistoryDto toDto(MemberNickNameHistory history) {
        return new MemberNickNameHistoryDto(
                history.getId(),
                history.getMemberId(),
                history.getNickname(),
                history.getCreatedAt()
        );
    }

}

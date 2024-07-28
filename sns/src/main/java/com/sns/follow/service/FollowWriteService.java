package com.sns.follow.service;

import com.sns.follow.entity.Follow;
import com.sns.follow.repository.FollowRepository;
import com.sns.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class FollowWriteService {
    final private FollowRepository followRepository;

    public void create(MemberDto fromMember, MemberDto toMember) {
        // Member 식별자를 통해 Member 검증은 어디에 위치하는가 ?
        // 서로 다른 도메인에서 데이터를 주고 받는것
        Assert.isTrue(!fromMember.id().equals(toMember.id()), "From, To 회원이 동일합니다.");

        var follow = Follow.builder()
                .fromMemberId(fromMember.id())
                .toMemberId(toMember.id())
                .build();
        followRepository.save(follow);

    }

}

package com.sns.application.usecase;

import com.sns.domain.follow.entity.Follow;
import com.sns.domain.follow.service.FollowReadService;
import com.sns.domain.member.dto.MemberDto;
import com.sns.domain.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetFollowingMemberUsecase {

    final private MemberReadService memberReadService;
    final private FollowReadService followReadService;


    public List<MemberDto> execute(Long memberId) {
        /*
          1. fromMemberId = memberId -> Follow List
          2. 1번을 순회하면서 회원정보를 찾으면된다 ?
        */
        var followings = followReadService.getFollowings(memberId);
        var followingMemberIds = followings.stream().map(Follow::getToMemberId).toList();
        return memberReadService.getMembers(followingMemberIds);


    }

}

package com.sns.application.usecase;

import com.sns.follow.service.FollowWriteService;
import com.sns.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateFolllowMemberUsecase {

    final private MemberReadService memberReadService;
    final private FollowWriteService followWriteService;


    public void execute(Long fromMemberId, Long toMemberId) {
        /*
         *   1. 입력받은 memberId로 회원조회
         *   2. FollowWriteService.create
         * */

//        xxx: UseCase는 Domain 계층간 흐름만 제어하도록 로직이 작성되어있어야함
        var fromMember = memberReadService.getMember(fromMemberId);
        var toMember = memberReadService.getMember(toMemberId);

        followWriteService.create(fromMember, toMember);

    }
}

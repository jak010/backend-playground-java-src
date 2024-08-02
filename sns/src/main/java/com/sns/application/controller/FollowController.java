package com.sns.application.controller;

import com.sns.application.usecase.CreateFolllowMemberUsecase;
import com.sns.application.usecase.GetFollowingMemberUsecase;
import com.sns.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {

    final private CreateFolllowMemberUsecase createFolllowMemberUsecase;
    final private GetFollowingMemberUsecase getFollowingMemberUsecase;

    @PostMapping("/{fromId}/{toId}")
    public void register(@PathVariable("fromId") Long fromId, @PathVariable("toId") Long toId) {
        createFolllowMemberUsecase.execute(fromId, toId);

    }

    @GetMapping("/members/{fromId}")
    public List<MemberDto> get(@PathVariable("fromId") Long fromId) {
        return getFollowingMemberUsecase.execute(fromId);
    }


}

package com.sns.controller;

import com.sns.member.dto.MemberDto;
import com.sns.member.dto.MemberNickNameHistoryDto;
import com.sns.member.dto.RegisterMemberCommand;
import com.sns.member.service.MemberReadService;
import com.sns.member.service.MemberWriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {
    final private MemberWriterService memberWriterService;
    final private MemberReadService memberReadService;

    @PostMapping("/members")
    public MemberDto register(@RequestBody RegisterMemberCommand command) {
        var member = memberWriterService.create(command);
        return memberReadService.toDto(member);
    }

    @GetMapping("/members/{id}")
    public MemberDto getMember(@PathVariable("id") Long id) {
        return memberReadService.getMember(id);
    }

    @PutMapping("/{id}/name")
    public MemberDto changeNickName(
            @PathVariable("id") Long id,
            @RequestBody String nickname
    ) {
        memberWriterService.chagneNickname(id, nickname);
        return memberReadService.getMember(id);
    }

    @GetMapping("/members/{memberId}/nickname-histories")
    public List<MemberNickNameHistoryDto> getNickNameHistories(@PathVariable("memberId") Long memberId) {
        return memberReadService.getNickNameHistories(memberId);
    }

}

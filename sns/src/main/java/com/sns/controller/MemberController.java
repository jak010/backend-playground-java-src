package com.sns.controller;

import com.sns.member.dto.RegisterMemberCommand;
import com.sns.member.entity.Member;
import com.sns.member.service.MemberWriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {
    final private MemberWriterService memberWriterService;

    @PostMapping("/members")
    public Member register(@RequestBody RegisterMemberCommand command) {
        return memberWriterService.create(command);
    }
}

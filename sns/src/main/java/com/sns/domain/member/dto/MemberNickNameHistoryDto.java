package com.sns.domain.member.dto;

import java.time.LocalDateTime;

public record MemberNickNameHistoryDto(
        Long Id,
        Long memberId,
        String nickname,
        LocalDateTime createdAt
) {
}

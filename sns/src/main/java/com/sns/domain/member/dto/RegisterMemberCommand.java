package com.sns.domain.member.dto;

import java.time.LocalDate;

public record RegisterMemberCommand(
        String email,
        String nickanme,
        LocalDate birthday
) {
}

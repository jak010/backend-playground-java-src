package com.sns.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Objects;

/*
 *  1. 필드가 같다고 해서 중복이 아님, 과거의 데이터 내역은 정규화 대상이 아님
 *  2. 데이터가 최신성을 남겨야하는지가 중점적임
 * */

@Getter
public class MemberNickNameHistory {

    final private Long id;
    final private Long memberId;
    final private String nickname;
    final private LocalDateTime createdAt;


    @Builder
    public MemberNickNameHistory(Long id, Long memberId, String nickname, LocalDateTime createdAt) {
        this.id = id;
        this.memberId = Objects.requireNonNull(memberId);
        this.nickname = Objects.requireNonNull(nickname);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }
}

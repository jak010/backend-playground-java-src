package com.sns.domain.post.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;


@Getter
public class TimeLine {

    final private Long id;
    final private Long memberId;
    final private Long postId;
    final private LocalDateTime createdAt;


    @Builder
    public TimeLine(Long id, Long memberId, Long postId, LocalDateTime createdAt) {
        this.id = id;
        this.memberId = Objects.requireNonNull(memberId);
        this.postId = Objects.requireNonNull(postId);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }
}

package com.sns.domain.follow.service;

import com.sns.domain.follow.entity.Follow;
import com.sns.domain.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FollowReadService {

    private final FollowRepository followRepository;

    public List<Follow> getFollowings(Long memberId) {
        return followRepository.findAllByFromMemberId(memberId);
    }


    public List<Follow> getFollowers(Long memberId) {
        return followRepository.findAllByToMemberId(memberId);
    }


}

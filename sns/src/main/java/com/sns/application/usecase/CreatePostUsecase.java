package com.sns.application.usecase;

import com.sns.domain.follow.entity.Follow;
import com.sns.domain.follow.service.FollowReadService;
import com.sns.domain.post.dto.PostCommand;
import com.sns.domain.post.service.PostWriteService;
import com.sns.domain.post.service.TimeLineWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreatePostUsecase {

    final private PostWriteService postWriteService;
    final private FollowReadService followReadService;
    final private TimeLineWriteService timeLineWriteService;

    // xxx: Transaction이 걸지는 고민해볼 문제임
    // xxx: Transaction 범위는 짧게 걸어주는게 좋음
    public Long execute(PostCommand postCommand) {
        var postId = postWriteService.create(postCommand);
        var followMemberIds = followReadService
                .getFollowers(postCommand.memberId())
                .stream()
                .map(Follow::getFromMemberId)
                .toList();

        timeLineWriteService.deliveryToTimeLine(postId, followMemberIds);
        return postId;
    }

}

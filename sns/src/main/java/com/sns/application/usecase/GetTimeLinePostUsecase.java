package com.sns.application.usecase;

import com.sns.domain.follow.entity.Follow;
import com.sns.domain.follow.service.FollowReadService;
import com.sns.domain.post.entity.Post;
import com.sns.domain.post.repository.PostRepository;
import com.sns.domain.post.service.PostReadService;
import com.sns.util.CursorRequest;
import com.sns.util.PageCursor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetTimeLinePostUsecase {

    final private FollowReadService followReadService;
    final private PostReadService postReadService;

    public PageCursor<Post> execute(Long memberId, CursorRequest cursorRequest) {
        /*
         *   1. memberId -> follow 조회
         *   2. 1번 결과로 게시물 조회
         * */
        var followings = followReadService.getFollowings(memberId);
        System.out.println(followings);
        var followingMemberIds = followings
                .stream()
                .map(Follow::getToMemberId)
                .toList();

        return postReadService.getPosts(followingMemberIds, cursorRequest);
    }
}

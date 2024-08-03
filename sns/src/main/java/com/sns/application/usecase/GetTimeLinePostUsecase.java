package com.sns.application.usecase;

import com.sns.domain.follow.entity.Follow;
import com.sns.domain.follow.service.FollowReadService;
import com.sns.domain.post.entity.Post;
import com.sns.domain.post.entity.TimeLine;
import com.sns.domain.post.service.PostReadService;
import com.sns.domain.post.service.TimeLineReadService;
import com.sns.util.CursorRequest;
import com.sns.util.PageCursor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetTimeLinePostUsecase {

    final private FollowReadService followReadService;
    final private PostReadService postReadService;
    final private TimeLineReadService timeLineReadService;

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

    public PageCursor<Post> executeByTimeLine(Long memberId, CursorRequest cursorRequest) {
        /*
         *   1. TimeLine 테이블 조회
         *   2. 1번에 해당하는 게시물을 조회
         * */
        var pagedtimelines = timeLineReadService.getTimelines(memberId, cursorRequest);
        var postIds = pagedtimelines.body().stream().map(TimeLine::getPostId).toList();
        var posts = postReadService.getPosts(postIds);

        return new PageCursor(pagedtimelines.nextCursorRequest(), posts);
    }

}

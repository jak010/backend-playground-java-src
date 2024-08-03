package com.sns.application.controller;

import com.sns.application.usecase.CreatePostLikeUsecase;
import com.sns.application.usecase.CreatePostUsecase;
import com.sns.application.usecase.GetTimeLinePostUsecase;
import com.sns.domain.post.dto.DailyPostCount;
import com.sns.domain.post.dto.DailyPostCountRequest;
import com.sns.domain.post.dto.PostCommand;
import com.sns.domain.post.dto.PostDto;
import com.sns.domain.post.entity.Post;
import com.sns.domain.post.service.PostReadService;
import com.sns.domain.post.service.PostWriteService;
import com.sns.util.CursorRequest;
import com.sns.util.PageCursor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    final private PostWriteService postWriteService;
    final private PostReadService postReadService;
    final private GetTimeLinePostUsecase getTimeLinePostUsecase;
    final private CreatePostUsecase createPostUsecase;

    final private CreatePostLikeUsecase createPostLikeUsecase;


    @PostMapping("")
    public Long create(@RequestBody PostCommand command) {
        return createPostUsecase.execute(command);
    }

    @GetMapping("/daily-post-counts")
    public List<DailyPostCount> getDailyPostCounts(DailyPostCountRequest request) {
        return postReadService.getDailyPostCount(request);
    }

    @GetMapping("/members/{memberId}")
    public Page<PostDto> getPosts(
            @PathVariable("memberId") Long memberId,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
    ) {
        return postReadService.getPostDtos(memberId, PageRequest.of(page, size));
    }

    @GetMapping("/members/{memberId}/by-cursor")
    public PageCursor<Post> getPostsByCursor(
            @PathVariable("memberId") Long memberId,
            CursorRequest cursorRequest
    ) {
        return postReadService.getPosts(memberId, cursorRequest);
    }


    @GetMapping("/members/{memberId}/timeline")
    public PageCursor<Post> getTimeLine(
            @PathVariable("memberId") Long memberId,
            CursorRequest cursorRequest
    ) {
        return getTimeLinePostUsecase.executeByTimeLine(memberId, cursorRequest);
    }

    @PostMapping("/{postId}/like/v1")
    public void likPost(
            @PathVariable("postId") Long postId
    ) {
        postWriteService.likePost(postId);
    }

    @PostMapping("/{postId}/like/v2")
    public void likPostV2(
            @PathVariable("postId") Long postId,
            @RequestParam("memberId") Long memberId
    ) {
        createPostLikeUsecase.execute(postId, memberId);
    }


    @PostMapping("/{postId}/like/optimistic-lock")
    public void likPostByOptimistic(
            @PathVariable("postId") Long postId
    ) {
        postWriteService.likePostByOptimisticLock(postId);
    }

}

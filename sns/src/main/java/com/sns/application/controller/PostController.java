package com.sns.application.controller;

import com.sns.domain.post.dto.DailyPostCount;
import com.sns.domain.post.dto.DailyPostCountRequest;
import com.sns.domain.post.dto.PostCommand;
import com.sns.domain.post.entity.Post;
import com.sns.domain.post.service.PostReadService;
import com.sns.domain.post.service.PostWriteService;
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

    @PostMapping("")
    public Long create(@RequestBody PostCommand command) {
        return postWriteService.create(command);
    }

    @GetMapping("/daily-post-counts")
    public List<DailyPostCount> getDailyPostCounts(DailyPostCountRequest request) {
        return postReadService.getDailyPostCount(request);
    }

    @GetMapping("/members/{memberId}")
    public Page<Post> getPosts(
            @PathVariable("memberId") Long memberId,
            Pageable pageRequest
    ) {
        return postReadService.getPosts(memberId, pageRequest);
    }

}

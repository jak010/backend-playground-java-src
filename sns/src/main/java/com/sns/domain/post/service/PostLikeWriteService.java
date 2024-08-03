package com.sns.domain.post.service;

import com.sns.domain.member.dto.MemberDto;
import com.sns.domain.post.entity.Post;
import com.sns.domain.post.entity.PostLike;
import com.sns.domain.post.repository.PostLikeRepository;
import com.sns.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.service.OpenAPIService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostLikeWriteService {

    final private PostLikeRepository postLikeRepository;

    public Long create(Post post, MemberDto memberDto) {

        var postLike = PostLike.builder()
                .postId(post.getId())
                .memberId(memberDto.id())
                .build();
        return postLikeRepository.save(postLike).getPostId();


    }


}

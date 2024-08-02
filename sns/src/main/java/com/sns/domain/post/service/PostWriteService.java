package com.sns.domain.post.service;

import com.sns.domain.post.dto.PostCommand;
import com.sns.domain.post.entity.Post;
import com.sns.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class PostWriteService {


    final private PostRepository postRepository;


    public Long create(@RequestBody PostCommand command) {
        var post = Post.builder()
                .memberId(command.memberId())
                .contents(command.contents())
                .build();
        return postRepository.save(post).getId();

    }


}

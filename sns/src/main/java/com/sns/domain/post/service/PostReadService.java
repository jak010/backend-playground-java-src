package com.sns.domain.post.service;

import com.sns.domain.post.dto.DailyPostCount;
import com.sns.domain.post.dto.DailyPostCountRequest;
import com.sns.domain.post.dto.PostDto;
import com.sns.domain.post.entity.Post;
import com.sns.domain.post.repository.PostLikeRepository;
import com.sns.domain.post.repository.PostRepository;
import com.sns.util.CursorRequest;
import com.sns.util.PageCursor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostReadService {

    final private PostRepository postRepository;
    final private PostLikeRepository postLikeRepository;

    public List<DailyPostCount> getDailyPostCount(DailyPostCountRequest request) {
        /*
         *   반환값 -> 리스트[작성일자, 작성회원, 작성 게시물 갯수]
         *       1. select * from Post where memberId = :memberId and createdDate between firstDate and lastDate group by createdDate memberId
         * */
        return postRepository.groupByCreatedDate(request);

    }

    public Page<PostDto> getPostDtos(Long memberId, Pageable pageRequest) {
        return postRepository.findAllByMemberId(memberId, pageRequest).map(this::toDto);
    }

    private PostDto toDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getContents(),
                post.getCreatedAt(),
                postLikeRepository.count(post.getId())
        );

    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId, false).orElseThrow();
    }

    public PageCursor<Post> getPosts(Long memberId, CursorRequest cursorRequest) {
        var posts = findAllBy(memberId, cursorRequest);
        long next_key = getNextKey(posts);
        return new PageCursor<>(cursorRequest.next(next_key), posts);
    }

    public PageCursor<Post> getPosts(List<Long> memberIds, CursorRequest cursorRequest) {
        var posts = findAllBy(memberIds, cursorRequest);
        long next_key = getNextKey(posts);
        return new PageCursor<>(cursorRequest.next(next_key), posts);
    }

    private static long getNextKey(List<Post> posts) {
        var next_key = posts.stream()
                .mapToLong(Post::getId)
                .min()
                .orElse(CursorRequest.NONE_KEY);
        return next_key;
    }

    public List<Post> getPosts(List<Long> ids) {
        return postRepository.findAllByInId(ids);
    }


    private List<Post> findAllBy(Long memberId, CursorRequest cursorRequest) {
        if (cursorRequest.hasKey()) {
            return postRepository.findAllByLessThanAndMemberIdAndOrderByIdDesc(cursorRequest.key(), memberId, cursorRequest.size());
        }
        return postRepository.findAllByMemberIdAndOrderByIdDesc(memberId, cursorRequest.size());
    }

    private List<Post> findAllBy(List<Long> memberIds, CursorRequest cursorRequest) {
        if (cursorRequest.hasKey()) {
            return postRepository.findAllByLessThanAndInMemberIdsAndOrderByIdDesc(cursorRequest.key(), memberIds, cursorRequest.size());
        }
        return postRepository.findAllByInMemberIdAndOrderByIdDesc(memberIds, cursorRequest.size());
    }

}

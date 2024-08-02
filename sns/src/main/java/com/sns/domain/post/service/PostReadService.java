package com.sns.domain.post.service;

import com.sns.domain.post.dto.DailyPostCount;
import com.sns.domain.post.dto.DailyPostCountRequest;
import com.sns.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostReadService {

    final private PostRepository postRepository;

    public List<DailyPostCount> getDailyPostCount(DailyPostCountRequest request) {
        /*
         *   반환값 -> 리스트[작성일자, 작성회원, 작성 게시물 갯수]
         *       1. select * from Post where memberId = :memberId and createdDate between firstDate and lastDate group by createdDate memberId
         * */
        return postRepository.groupByCreatedDate(request);

    }


}

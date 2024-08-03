package com.sns.domain.post.service;

import com.sns.domain.post.entity.Post;
import com.sns.domain.post.entity.TimeLine;
import com.sns.domain.post.repository.TimeLineRepository;
import com.sns.util.CursorRequest;
import com.sns.util.PageCursor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TimeLineReadService {
    final private TimeLineRepository timeLineRepository;

    public PageCursor<TimeLine> getTimelines(Long memberId, CursorRequest cursorRequest) {
        var timeline = findAllBy(memberId, cursorRequest);
        var nextkey = timeline.stream()
                .mapToLong(TimeLine::getId)
                .min()
                .orElse(CursorRequest.NONE_KEY);

        return new PageCursor<>(cursorRequest.next(nextkey), timeline);

    }


    private List<TimeLine> findAllBy(Long memberId, CursorRequest cursorRequest) {
        if (cursorRequest.hasKey()) {
            return timeLineRepository.findAllByLessThanAndMemberIdAndOrderByIdDesc(cursorRequest.key(), memberId, cursorRequest.size());
        }
        return timeLineRepository.findAllByMemberIdAndOrderByIdDesc(memberId, cursorRequest.size());
    }


}

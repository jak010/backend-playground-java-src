package com.sns.domain.post;

import com.sns.domain.post.entity.Post;
import com.sns.domain.post.repository.PostRepository;
import com.sns.util.PostFixtureFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.util.stream.IntStream;

// @SpringBootTest Annotation과 함께 `@Transactional` Annotation을 붙이면 rollback이 된다.
// @Transactional
@SpringBootTest
public class PostBulkInsertTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void bulkInsert() {
        var easyRandom = PostFixtureFactory.get(
                3L,
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 2, 1)
        );
        var stopWatch = new StopWatch();
        stopWatch.start();

        var posts = IntStream.range(0, 20000 * 100)
                .parallel()
                .mapToObj(i -> easyRandom.nextObject(Post.class))
                .toList();
        stopWatch.stop();

        System.out.println("객체 생성 시간" + stopWatch.getTotalTimeSeconds());

        var queryStopWatch = new StopWatch();
        queryStopWatch.start();
        postRepository.bulkInsert(posts);
        queryStopWatch.stop();

        System.out.println("DB INSERT 시간" + queryStopWatch.getTotalTimeSeconds());

    }
}

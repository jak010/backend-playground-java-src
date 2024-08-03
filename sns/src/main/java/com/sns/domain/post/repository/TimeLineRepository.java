package com.sns.domain.post.repository;

import com.sns.domain.post.entity.Post;
import com.sns.domain.post.entity.TimeLine;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class TimeLineRepository {

    final private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final private String TABLE = "Timeline";

    final static private RowMapper<TimeLine> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> TimeLine.builder()
            .id(resultSet.getLong("id"))
            .memberId(resultSet.getLong("memberId"))
            .postId(resultSet.getLong("postId"))
            .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
            .build();


    public TimeLine save(TimeLine timeline) {
        if (timeline.getId() == null) {
            return insert(timeline);
        }
        throw new UnsupportedOperationException("TimeLine은 갱신을 지원하지 않습니다.");
    }

    public List<TimeLine> findAllByMemberIdOrderByIdDesc(Long memberId, int size) {
        var sql = String.format("""
                SELECT *
                FROM %s
                WHERE memberId=:memberId
                ORDER BY id desc
                LIMIT :size
                """, TABLE);
        var params = new MapSqlParameterSource()
                .addValue("memberId", memberId)
                .addValue("size", size);
        return namedParameterJdbcTemplate.query(sql, params, ROW_MAPPER);
    }


    public List<TimeLine> findAllByLessThanAndMemberIdAndOrderByIdDesc(Long id, Long memberId, int size) {
        var sql = String.format("""
                SELECT *
                FROM %s
                WHERE memberId=:memberId and id <:id
                ORDER BY id desc
                LIMIT :size
                """, TABLE);
        var params = new MapSqlParameterSource()
                .addValue("memberId", memberId)
                .addValue("id", id)
                .addValue("size", size);
        return namedParameterJdbcTemplate.query(sql, params, ROW_MAPPER);
    }

    public List<TimeLine> findAllByMemberIdAndOrderByIdDesc(Long memberId, int size) {
        var sql = String.format("""
                SELECT *
                FROM %s
                WHERE memberId=:memberId
                ORDER BY id desc
                LIMIT :size
                """, TABLE);
        var params = new MapSqlParameterSource()
                .addValue("memberId", memberId)
                .addValue("size", size);
        return namedParameterJdbcTemplate.query(sql, params, ROW_MAPPER);
    }

    public TimeLine insert(TimeLine timeline) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
                .withTableName(TABLE)
                .usingGeneratedKeyColumns("id");

        SqlParameterSource params = new BeanPropertySqlParameterSource(timeline);
        var id = jdbcInsert.executeAndReturnKey(params).longValue();

        return TimeLine.builder()
                .id(id)
                .memberId(timeline.getMemberId())
                .postId(timeline.getPostId())
                .createdAt(timeline.getCreatedAt())
                .build();
    }

    public void bulkInsert(List<TimeLine> timeLines) {
        var sql = String.format("""
                INSERT INTO `%s` (memberId, postId, createdAt)
                VALUES (:memberId, :postId, :createdAt)
                """, TABLE);
        SqlParameterSource[] params = timeLines
                .stream()
                .map(BeanPropertySqlParameterSource::new)
                .toArray(SqlParameterSource[]::new);
        namedParameterJdbcTemplate.batchUpdate(sql, params);
    }

}

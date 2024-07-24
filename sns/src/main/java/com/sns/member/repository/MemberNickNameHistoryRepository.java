package com.sns.member.repository;

import com.sns.member.entity.Member;
import com.sns.member.entity.MemberNickNameHistory;
import jakarta.persistence.Table;
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
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberNickNameHistoryRepository {

    final private NamedParameterJdbcTemplate namedParameterjdbcTemplate;


    static final private String TABLE = "MemberNicknameHistory";

    static final RowMapper<MemberNickNameHistory> rowMapper = (ResultSet resultSet, int rowNum) -> MemberNickNameHistory
            .builder()
            .id(resultSet.getLong("id"))
            .memberId(resultSet.getLong("memberId"))
            .nickname(resultSet.getString("nickname"))
            .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
            .build();

    public List<MemberNickNameHistory> findAllByMemberId(Long memberId) {
        var sql = String.format("SELECT * FROM %s WHERE memberId = :memberId", TABLE);
        var params = new MapSqlParameterSource().addValue("memberId", memberId);
        return namedParameterjdbcTemplate.query(sql, params, rowMapper);
    }


    public MemberNickNameHistory save(MemberNickNameHistory history) {
    /*
        member id를 보고 갱신 또는 삽입을 정함, 반환값은 id를 담아서 반환
    * */
        if (history.getId() == null) {
            return insert(history);
        }
        throw new UnsupportedOperationException("MemberNickNameHistory는 갱신을 지원하지 않습니다.");
    }

    private MemberNickNameHistory insert(MemberNickNameHistory history) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterjdbcTemplate.getJdbcTemplate())
                .withTableName(TABLE)
                .usingGeneratedKeyColumns("id");

        SqlParameterSource params = new BeanPropertySqlParameterSource(history);
        var id = simpleJdbcInsert.executeAndReturnKey(params).longValue();
        return MemberNickNameHistory
                .builder()
                .id(id)
                .memberId(history.getMemberId())
                .nickname(history.getNickname())
                .createdAt(history.getCreatedAt())
                .build();
    }
}

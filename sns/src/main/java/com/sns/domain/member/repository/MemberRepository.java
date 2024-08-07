package com.sns.domain.member.repository;

import com.sns.domain.member.entity.Member;
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
public class MemberRepository {

    final private NamedParameterJdbcTemplate namedParameterjdbcTemplate;


    static final private String TABLE = "Member";
    // xxx: BeanPropertyRowMappers는 Setter를 열어줘야함
    RowMapper<Member> rowMapper = (ResultSet resultSet, int rowNum) -> Member
            .builder()
            .id(resultSet.getLong("id"))
            .email(resultSet.getString("email"))
            .nickname(resultSet.getString("nickname"))
            .birthday(resultSet.getObject("birthday", LocalDate.class))
            .createdAt(resultSet.getObject("createdAt", LocalDateTime.class))
            .build();


    public Optional<Member> findById(Long id) {

        var sql = String.format("SELECT * FROM %s WHERE id = :id  ", TABLE);
        var param = new MapSqlParameterSource()
                .addValue("id", id);

        var member = namedParameterjdbcTemplate.queryForObject(sql, param, rowMapper);

        return Optional.ofNullable(member);
    }

    public Member save(Member member) {
    /*
        member id를 보고 갱신 또는 삽입을 정함, 반환값은 id를 담아서 반환
    * */
        if (member.getId() == null) {
            return insert(member);
        }

        return update(member);
    }


    public List<Member> findAllByIdIn(List<Long> ids) {
        if (ids.isEmpty())
            return List.of();

        var sql = String.format("SELECT * FROM %s WHERE id in (:ids)", TABLE);
        var params = new MapSqlParameterSource()
                .addValue("ids", ids);
        return namedParameterjdbcTemplate.query(sql, params, rowMapper);
    }

    private Member insert(Member member) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterjdbcTemplate.getJdbcTemplate())
                .withTableName("Member")
                .usingGeneratedKeyColumns("id");

        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        var id = simpleJdbcInsert.executeAndReturnKey(params).longValue();
        return Member
                .builder()
                .id(id)
                .email(member.getEmail())
                .nickname(member.getNickname())
                .birthday(member.getBirthday())
                .build();
    }

    private Member update(Member member) {
        var sql = String.format("UPDATE %s SET email = :email, nickname = :nickname, birthday = :birthday WHERE id = :id;", TABLE);
        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        namedParameterjdbcTemplate.update(sql, params);
        return member;
    }

}

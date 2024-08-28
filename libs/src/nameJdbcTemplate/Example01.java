package nameJdbcTemplate;

import common.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.time.LocalDateTime;

public class Example01 {

    void example01() {
        DriverManagerDataSource driverManager = new DriverManagerDataSource();
        driverManager.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManager.setUrl("jdbc:mysql://127.0.0.1:9901/sample");
        driverManager.setUsername("root");
        driverManager.setPassword("1234");


        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManager);

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(driverManager);

        RowMapper<Member> memberRowMapper = (ResultSet resultSet, int row) -> new Member(
                resultSet.getLong("id"),
                resultSet.getString("email"),
                resultSet.getString("nickname"),
                resultSet.getObject("birthday", LocalDateTime.class),
                resultSet.getObject("createdAt", LocalDateTime.class)
        );

        String insertSQL = "INSERT INTO Member (email, nickname, birthday, createdAt) VALUES(:email, :nickname, :birthday, :createdAt)";

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("email", "test2@test2.com")
                .addValue("nickname", "test2")
                .addValue("birthday", "1999-01-01")
                .addValue("createdAt", "1999-01-01");

        namedParameterJdbcTemplate.update(insertSQL, mapSqlParameterSource);
    }


}

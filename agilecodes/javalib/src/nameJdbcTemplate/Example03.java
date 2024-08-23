package nameJdbcTemplate;

import common.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.time.LocalDateTime;

public class Example03 {

    public static void main(String[] args) {


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

        Member member = new Member(
                "test3@email.com",
                "test3",
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        namedParameterJdbcTemplate.update(insertSQL, params);


//        namedParameterJdbcTemplate.update(insertSQL, mapSqlParameterSource);

    }

}

package nameJdbcTemplate;

import common.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.time.LocalDateTime;

public class Example04 {

    void example04() {


        DriverManagerDataSource driverManager = new DriverManagerDataSource();
        driverManager.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManager.setUrl("jdbc:mysql://127.0.0.1:9901/sample");
        driverManager.setUsername("root");
        driverManager.setPassword("1234");


        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManager);

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(driverManager);

        RowMapper<Member> memberRowMapper = (ResultSet resultSet, int row) -> new Member(
                resultSet.getString("email"),
                resultSet.getString("nickname"),
                resultSet.getObject("birthday", LocalDateTime.class),
                resultSet.getObject("createdAt", LocalDateTime.class)
        );


        String insertSQL = "INSERT INTO Member (email, nickname, birthday, createdAt) VALUES(:email, :nickname, :birthday, :createdAt)";
        SqlParameterSource params = new BeanPropertySqlParameterSource(
                new Member(
                        "test4@email.com",
                        "test4",
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(insertSQL, params, keyHolder);

        long key = keyHolder.getKey().longValue();
        System.out.println(key);

    }

}

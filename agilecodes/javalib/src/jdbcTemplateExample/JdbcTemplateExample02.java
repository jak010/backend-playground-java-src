package jdbcTemplateExample;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.time.LocalDateTime;

import common.Member;

public class JdbcTemplateExample02 {


    public static void main(String[] args) {

        DriverManagerDataSource driverManager = new DriverManagerDataSource();
        driverManager.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManager.setUrl("jdbc:mysql://127.0.0.1:9901/sample");
        driverManager.setUsername("root");
        driverManager.setPassword("1234");


        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManager);
        RowMapper<Member> memberRowMapper = (ResultSet resultSet, int row) -> new Member(
                resultSet.getLong("id"),
                resultSet.getString("email"),
                resultSet.getString("nickname"),
                resultSet.getObject("birthday", LocalDateTime.class),
                resultSet.getObject("createdAt", LocalDateTime.class)
        );

        String insertSQL = "INSERT INTO Member (email, nickname, birthday, createdAt) " +
                "VALUES (:email, :nickname, :birthday, :createdAt)";
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("email", "test2")
                .addValue("nickname", "test2@email.com")
                .addValue("birthday", "2002-01-01")
                .addValue("createdAt", "2002-02-02");

        jdbcTemplate.update(insertSQL, param.getValues());
    }

}

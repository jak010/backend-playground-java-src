package jdbcTemplateExample;

import common.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import java.sql.ResultSet;
import java.time.LocalDateTime;


public class JdbcTemplateExample01 {


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

        String insertSQL = "INSERT INTO Member (email, nickname, birthday, createdAt) VALUES(?, ?, ?, ?)";
        int rows = jdbcTemplate.update(insertSQL, "test2", "test2@email.com", "2002-01-01", "2002-02-02");

        System.out.println(rows);


    }

}

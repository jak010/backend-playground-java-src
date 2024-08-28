package jdbcPractice;

import java.sql.*;
import java.sql.Connection;

public class jdbcExample02 {

    public static void main(String[] args) {

        // Driver 클래스 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            // DB 연결을 위한 Connection 객체
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:9901/sample", "root", "1234");

            // SQL
            String insertSql = "INSERT INTO sample.`Member` (email, nickname, birthday, createdAt) VALUES(?, ?, ?, ?);";

            PreparedStatement pstmt = connection.prepareStatement(insertSql);
            pstmt.setString(1, "test@test.com");
            pstmt.setInt(2, 123);
            pstmt.setString(3, "2001-01-01");
            pstmt.setString(4, "1999-01-01");


            int rows = pstmt.executeUpdate();
            System.out.println(rows);
//            ResultSet rs = pstmt.executeQuery();

//            while (rs.next()) {
//                System.out.println(rs.toString());
//            }
//            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

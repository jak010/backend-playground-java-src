package jdbcPractice;

import java.sql.*;
import java.sql.Connection;


public class jdbcExample01 {

    Connection connection;


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
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Member");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "," + rs.getString("email") + "," + rs.getInt("nickname"));
            }
            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

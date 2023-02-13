package ssemi.ssemibucks.DbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {
    public static void main(String[] args) throws SQLException {
        Connection con = null;

        String server = "mydb-ssemi.cnuqpysc3avl.ap-northeast-1.rds.amazonaws.com"; // MySQL 서버 주소
        String database = "mydb_ssemi"; // MySQL DATABASE 이름
        String user_name = "ssemi"; //  MySQL 서버 아이디
        String password = "ssemi1226"; // MySQL 서버 비밀번호

        // 1.드라이버 로딩
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
//            e.printStackTrace();
//        }

        // 2.연결
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database, user_name, password);
            System.out.println("정상적으로 연결되었습니다.");
        } catch(SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
            e.printStackTrace();
        }

        // 3.해제
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
    }
}

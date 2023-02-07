package ssemi.ssemibucks.DbConnection;

import java.sql.*;

public class DbConnect {
    static final String URL = "jdbc:mysql://mydb-ssemi.cnuqpysc3avl.ap-northeast-1.rds.amazonaws.com:3306/mydb_ssemi";

    public Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, "ssemi", "ssemi1226");

        } catch (SQLException e) {
            System.out.println("mysql 계정 연결 실패 : " + e.getMessage());
        }
        return conn;
    }
    
    public void dbClose(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if(rs != null)
                rs.close();
            if(stmt != null)
                stmt.close();
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if(rs != null)
                rs.close();
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dbClose(Statement stmt, Connection conn) {
        try {
            if(stmt != null)
                stmt.close();
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dbClose(PreparedStatement pstmt, Connection conn) {
        try {
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
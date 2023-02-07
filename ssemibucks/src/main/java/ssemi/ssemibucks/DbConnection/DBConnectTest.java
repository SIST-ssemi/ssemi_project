package ssemi.ssemibucks.DbConnection;

import java.sql.*;

public class DBConnectTest {
    static final String URL = "jdbc:mysql://mydb-ssemi.cnuqpysc3avl.ap-northeast-1.rds.amazonaws.com:3306/mydb_ssemi";

    public void connectUser() {
        Connection conn = null;  // 메소드에서는 초기값 없으면 오류
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "select * from USER";

        try {
            conn = DriverManager.getConnection(URL, "ssemi","ssemi1226");

            System.out.println("연결 성공\n");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);  // --> sql문 전달, rs만 executeQuery

            System.out.println("[리스트]");
            System.out.println("uId\tuName\tpw\thp\taddr");
            System.out.println("---------------------------------------");

            // 여러 줄 가져와야할 경우 while문 사용
            // rs.next() : 다음 데이터로 (행 단위로) 이동하며 true 반환, 더 이상 데이터가 없으면 false 반환
            while(rs.next()) {
                // DB로부터 데이터 가져오기
                String uId = rs.getString("uId");  // DB의 컬럼명과 일치해야 함
                String uName = rs.getString("uName");
                int pw = rs.getInt("pw");
                String hp = rs.getString("hp");
                String addr = rs.getString("addr");

				/*
				int num = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String buseo = rs.getNString(4);
				int pay = rs.getInt(5);
				*/

                System.out.println(uId + "\t" + uName + "\t" + pw + "\t" + hp + "\t" + addr);
                //System.out.println(uName);

            }
        } catch (SQLException e) {
            System.out.println("연결 실패 : " + e.getMessage());
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        public static void main(String[] args) {

            DBConnectTest dbconn = new DBConnectTest();
            dbconn.connectUser();
            System.out.println("==========================================================");
        }
    }

package ssemi.ssemibucks.CART;

import ssemi.ssemibucks.DbConnection.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDao {
    DbConnect db = new DbConnect();

    //장바구니 목록 조회
    public void selectCart(){
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from CART";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("상품ID\t상품명\t\t상품옵션\t상품가격\t상품수량");
                System.out.println("==================================================");
                do {
                    System.out.println(rs.getString("pId") + "\t" +
                            rs.getString("pName") + "\t" +
                            rs.getString("pOption") + "\t\t" +
                            rs.getString("price") + "\t" +
                            rs.getString("cQTY"));
                } while (rs.next());

            } else {
                System.out.println("장바구니에 상품이 없습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

    }
}

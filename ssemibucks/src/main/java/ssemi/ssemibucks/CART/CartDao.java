package ssemi.ssemibucks.CART;

import ssemi.ssemibucks.DbConnection.DbConnect;
import ssemi.ssemibucks.PRODUCT.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CartDao {

    Scanner sc = new Scanner(System.in);
    DbConnect db = new DbConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "";

    // 장바구니 추가
    public void insertCart(Product product, int cQTY) {
        Connection conn = db.getConnection();

        sql = "insert into CART values(?, ?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, product.getpId());
            pstmt.setString(2, product.getpName());
            pstmt.setString(3, product.getpOption());
            pstmt.setInt(4, product.getPrice());
            pstmt.setInt(5, cQTY);

            pstmt.execute();

            System.out.println("\n장바구니 추가 완료\n\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 장바구니 삭제
    public void deleteCart(String pId, String pName) {
        Connection conn = db.getConnection();

        sql = "delete from CART where pId = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pId);

            pstmt.execute();
            System.out.println("장바구니 - [" + pName + "] 삭제 완료\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
    }

    // 장바구니 수정 - 수량
    public void updateCart(String pId, String pName, int cQTY) {
        Connection conn = db.getConnection();

        sql = "update CART set cQTY =? where pId = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, cQTY);
            pstmt.setString(2, pId);

            int n = pstmt.executeUpdate();
            if (n == 1)
                System.out.println("장바구니 - [" + pName + "]의 수정 완료\n\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 상품 아이디 존재 여부 확인 - 중복 상품 등록 방지
    public Cart findBypId(String pId) {
        Connection conn = db.getConnection();
        Cart cart = null;

        sql = "select * from CART where pId = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, pId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                cart = new Cart(rs.getString("pId"), rs.getString("pName"), rs.getInt("cQTY"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return cart;
    }
}

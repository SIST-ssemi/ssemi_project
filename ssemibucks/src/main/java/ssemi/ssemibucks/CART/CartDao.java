package ssemi.ssemibucks.CART;

import org.springframework.stereotype.Repository;
import ssemi.ssemibucks.DbConnection.DbConnect;
import ssemi.ssemibucks.PRODUCT.Product;
import ssemi.ssemibucks.USER.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

@Repository
public class CartDao {

    Scanner sc = new Scanner(System.in);
    DbConnect db = new DbConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "";

    //장바구니 목록 조회
    public Vector<Cart> selectCart(String uId) throws SQLException {
        Vector<Cart> list = new Vector<>();

        Connection conn = db.getConnection();

        sql = "select * from CART C JOIN PRODUCT P ON C.pId=P.pId where uId=?;";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,uId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Cart cart = new Cart();

                cart.setcId(rs.getString("cId"));
                cart.setuId(rs.getString("uId"));
                cart.setpId(rs.getString("pId"));
                cart.setpName(rs.getString("pName"));
                cart.setpOption(rs.getString("pOption"));
                cart.setCategory(rs.getString("category"));
                cart.setPrice(rs.getInt("price"));
                cart.setcQty(rs.getInt("cQTY"));
                cart.setpImage(rs.getString("pImage"));

                list.add(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
        return list;

    }

    // 장바구니 추가
    public void insertCart(String uId, String pId, int cQTY) {
        Connection conn = db.getConnection();

        sql = "insert into CART values(null, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, uId);
            pstmt.setString(2, pId);
            pstmt.setInt(3, cQTY);

            pstmt.execute();

            System.out.println("\n장바구니 추가 완료\n\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    public Cart findByCart(String findcId) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Cart cart = new Cart();

        String sql = "select * from CART where cId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, findcId);

            pstmt.execute();

            rs = pstmt.executeQuery();

            if (rs.next()) {
                cart.setcId(rs.getString("cId"));
                cart.setpId(rs.getString("pId"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
        return cart;
    }


    // 장바구니 삭제
    public void deleteCart(String cId) {
        Connection conn = db.getConnection();

        sql = "delete from CART where cId = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cId);

            pstmt.execute();
            System.out.println(" 삭제 완료\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 장바구니 수정 - 수량
    public void updateCart(String cId, int cQTY) {
        Connection conn = db.getConnection();

        sql = "update CART set cQTY =? where cId = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, cQTY);
            pstmt.setString(2, cId);

            int n = pstmt.executeUpdate();
            if (n == 1)
                System.out.println("장바구니 수정 완료\n\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 상품 아이디 존재 여부 확인 - 중복 상품 등록 방지
   public Cart findBypId(String uId, String pId) {
        Connection conn = db.getConnection();
        Cart cart = new Cart();

        sql = "select * from CART C JOIN PRODUCT P ON C.pId = P.pId where uId = ? and C.pId = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, uId);
            pstmt.setString(2, pId);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                cart.setcId(rs.getString("cId"));
                cart.setpName(rs.getString("pName"));
                cart.setcQty(rs.getInt("cQTY"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return cart;
    }
}

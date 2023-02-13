package ssemi.ssemibucks.PRODUCT;

import ssemi.ssemibucks.DbConnection.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDao {

    Scanner sc = new Scanner(System.in);
    DbConnect db = new DbConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "";

    // 전체 상품 목록
    public void selectAllProduct() {
        Connection conn = db.getConnection();

        sql = "select * from PRODUCT";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("전체 상품 목록");
                System.out.println("pId\tpName\tpOption\tcategory\tprice\tpStock\tpDetail\tpImage");
                System.out.println("-------------------------------------------------------------------");

                do {
                    System.out.println(rs.getString("pId") + "\t"
                            + rs.getString("pName") + "\t"
                            + rs.getString("pOption") + "\t"
                            + rs.getString("category") + "\t"
                            + rs.getInt("price") + "\t"
                            + rs.getInt("pStock") + "\t"
                            + rs.getString("pDetail") + "\t"
                            + rs.getString("pImage") + "\t");
                } while (rs.next());

                System.out.println("\n상품 목록 조회 완료\n\n");
            } else {
                System.out.println("상품 목록 없음\n\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
    }

    // 상품 상세페이지
    public void selectProduct(String pId) {
        Connection conn = db.getConnection();

        sql = "select * from PRODUCT where pId = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pId);
            rs = pstmt.executeQuery();

            System.out.println("상품 상세 조회");
            System.out.println("pId\tpName\tpOption\tcategory\tprice\tpStock\tpDetail\tpImage");
            System.out.println("-------------------------------------------------------------------");

            while (rs.next()) {
                System.out.println(rs.getString("pId") + "\t"
                        + rs.getString("pName") + "\t"
                        + rs.getString("pOption") + "\t"
                        + rs.getString("category") + "\t"
                        + rs.getInt("price") + "\t"
                        + rs.getInt("pStock") + "\t"
                        + rs.getString("pDetail") + "\t"
                        + rs.getString("pImage") + "\t");
            }

            System.out.println("\n상품 목록 조회 완료\n\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
    }

    // 상품 추가
    public void insertProduct(Product product) {
        Connection conn = db.getConnection();

        sql = "insert into PRODUCT values(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, product.getpId());
            pstmt.setString(2, product.getpName());
            pstmt.setString(3, product.getpOption());
            pstmt.setString(4, product.getCategory());
            pstmt.setInt(5, product.getPrice());
            pstmt.setInt(6, product.getpStock());
            pstmt.setString(7, product.getpDetail());
            pstmt.setString(8, product.getpImage());

            pstmt.execute();
            System.out.println("\n상품 추가 완료\n\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 상품 삭제
    public void deleteProduct(String pId, String pName) {
        Connection conn = db.getConnection();

        sql = "delete from PRODUCT where pId = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pId);

            pstmt.execute();
            System.out.println("[" + pName + "] 삭제 완료\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

    }

    // 상품 수정
    public void updateProduct(String pId, String pName, String sql, int input) {

        Connection conn = db.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);

            // pstmt.setString(1, str);
            pstmt.setInt(1, input);
            pstmt.setString(2, pId);
            
            pstmt.execute();
            System.out.println("[" + pName + "] 수정 완료\n\n");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }

    }

    // 상품 아이디 존재 여부 확인 - 중복 상품 등록 방지
    public Product findBypId(String pId) {
        Connection conn = db.getConnection();
        Product product = null;

        sql = "select * from PRODUCT where pId = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, pId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                product = new Product(rs.getString("pId"), rs.getString("pName"), rs.getString("pOption"), rs.getInt("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return product;
    }
}

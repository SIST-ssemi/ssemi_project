package ssemi.ssemibucks.PRODUCT;

import org.springframework.stereotype.Repository;
import ssemi.ssemibucks.DbConnection.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

@Repository
public class ProductDao {
    Scanner sc = new Scanner(System.in);
    DbConnect db = new DbConnect();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "";

    // 전체 상품 목록
    public Vector<Product> selectAllProduct() {
        Vector<Product> list = new Vector<>();

        Connection conn = db.getConnection();

        sql = "select * from PRODUCT";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                Product product = new Product();

                product.setpId(rs.getString("pId"));
                product.setpName(rs.getString("pName"));
                product.setpOption(rs.getString("pOption"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getInt("price"));
                product.setpStock(rs.getInt("pStock"));
                product.setpDetail(rs.getString("pDetail"));
                product.setpImage(rs.getString("pImage"));

                // list 추가
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
        return list;
    }

    // 카테고리별 상품 목록
    public Vector<Product> selectCategoryProduct(String category) {
        Vector<Product> categoryList = new Vector<>();

        Connection conn = db.getConnection();

        sql = "select * from PRODUCT where category = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                Product product = new Product();

                product.setpId(rs.getString("pId"));
                product.setpName(rs.getString("pName"));
                product.setpOption(rs.getString("pOption"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getInt("price"));
                product.setpStock(rs.getInt("pStock"));
                product.setpDetail(rs.getString("pDetail"));
                product.setpImage(rs.getString("pImage"));

                // list 추가
                categoryList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
        return categoryList;
    }

    // 상품 상세페이지
    public Product selectProduct(String pId) {
        Product product = new Product();

        Connection conn = db.getConnection();

        sql = "select * from PRODUCT where pId = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pId);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                product.setpId(rs.getString("pId"));
                product.setpName(rs.getString("pName"));
                product.setpOption(rs.getString("pOption"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getInt("price"));
                product.setpStock(rs.getInt("pStock"));
                product.setpDetail(rs.getString("pDetail"));
                product.setpImage(rs.getString("pImage"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
        return product;
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
    public void deleteProduct(Product product) {
        Connection conn = db.getConnection();

        sql = "delete from PRODUCT where pId = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getpId());

            pstmt.execute();
            System.out.println("\n상품 삭제 완료\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

    }

    // 상품 수정
    public void updateProduct(Product product) {

        Connection conn = db.getConnection();

        String sql = "update team set price =?, pStock = ?, pDetail = ?, pImage = ? where pId = ?";
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, product.getPrice());
            pstmt.setInt(2, product.getpStock());
            pstmt.setString(3, product.getpDetail());
            pstmt.setString(4, product.getpImage());
            pstmt.setString(5, product.getpId());

            pstmt.execute();
            System.out.println("\n상품 수정 완료\n\n");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }

    }

    // 상품 아이디 존재 여부 확인 - 중복 상품 등록 방지
    public Product findBypId(String pId) {
        Connection conn = db.getConnection();
        Product product = new Product();

        sql = "select * from PRODUCT where pId = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, pId);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                product.setpId(rs.getString("pId"));
                product.setpName(rs.getString("pName"));
                product.setpOption(rs.getString("pOption"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getInt("price"));
                product.setpStock(rs.getInt("pStock"));
                product.setpDetail(rs.getString("pDetail"));
                product.setpImage(rs.getString("pImage"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return product;
    }
}
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
    Connection conn = db.getConnection();


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

        // 상품 아이디 존재 여부 확인
        if (findBypId(pId) == null) {
            System.out.println("해당 상품 정보 없음\n\n");
            return;
        }

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
    public void deleteProduct(String pId) {
        Connection conn = db.getConnection();
        Product product = findBypId(pId);
        int num;

        sql = "delete from PRODUCT where pId = ?";

        // 상품 아이디 존재 여부 확인
        if (product == null) {
            System.out.println("해당 상품 정보 없음\n\n");
            return;
        }

        String pName = product.getpName();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pId);

            System.out.println("[" + pName + "] 삭제하시겠습니까?  1:yes  2:no");
            System.out.print("번호 입력 : ");
            num = Integer.parseInt(sc.nextLine());
            System.out.println();

            if (num == 1) {
                int n = pstmt.executeUpdate();

                if (n == 1)
                    System.out.println("[" + pName + "] 삭제 완료\n\n");
            } else if (num == 2) {
                System.out.println("삭제 취소\n\n");
                return;
            } else {
                System.out.println("해당 번호 없음\n\n");
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

    }

    // 상품 수정
    public void updateProduct(String pId) {
        Product product = findBypId(pId);
        int num1, num2, input;

        Connection conn = db.getConnection();

        // 가격
        String SqlPrice = "update PRODUCT set price = ? where pId = ?";

        // 수량
        String sqlStock = "update PRODUCT set pStock = ? where pId = ?";

        // 상품 아이디 존재 여부 확인
        if (product == null) {
            System.out.println("해당 상품 정보 없음\n\n");
            return;
        }

        String pName = product.getpName();

        System.out.println("[" + pName + "] 수정하시겠습니까?  1:yes  2:no");
        System.out.print("번호 입력 : ");
        num1 = Integer.parseInt(sc.nextLine());
        System.out.println();

        if (num1 == 1) {
            System.out.println("[" + pName + "] 수정 - 1:가격  2:수량");
            System.out.print("번호 입력 : ");
            num2 = Integer.parseInt(sc.nextLine());
            System.out.println();

            if (num2 == 1) {
                sql = SqlPrice;

                System.out.print("[" + pName + "] 수정할 가격 입력 : ");
                input = Integer.parseInt(sc.nextLine());
                System.out.println();
            } else if (num2 == 2) {
                sql = sqlStock;

                System.out.print("[" + pName + "] 수정할 수량 입력 : ");
                input = Integer.parseInt(sc.nextLine());
                System.out.println();
            } else {
                System.out.println("해당 번호 없음\n\n");
                return;
            }
        } else if (num1 == 2) {
            System.out.println("[" + pName + "] 수정 취소\n\n");
            return;
        } else {
            System.out.println("해당 번호 없음\n\n");
            return;
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, input);
            pstmt.setString(2, pId);

            int n = pstmt.executeUpdate();
            if (n == 1)
                System.out.println("[" + pName + "] 수정 완료\n\n");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
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
                product = new Product(rs.getString("pId"), rs.getString("pName"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return product;
    }

}

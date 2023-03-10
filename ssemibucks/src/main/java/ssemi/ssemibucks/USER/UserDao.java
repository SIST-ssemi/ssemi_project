package ssemi.ssemibucks.USER;

import org.springframework.stereotype.Repository;
import ssemi.ssemibucks.DbConnection.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

@Repository
public class UserDao {
    DbConnect db = new DbConnect();
    Scanner sc = new Scanner(System.in);

    //회원 검색
    public User findByUser(String findId) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        User user = null;

        String sql = "select * from USER where uId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, findId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("uId"), rs.getString("pw"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
        return user;
    }

    //아이디 중복체크
    public String idDuplication(String uId) {
        String str = "";
        if (findByUser(uId) == null) {
            str = "사용가능아이디";
        } else {
            str = "중복아이디";
        }
        return str;
    }

    //모든회원조회
    public Vector<User> selectAllUser() {
        Vector<User> list = new Vector<>();

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from USER order by uName";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();


            while (rs.next()) {
                User user = new User();

                user.setuId(rs.getString("uId"));
                user.setuName(rs.getString("uName"));
                user.setPw(rs.getString("pw"));
                user.setHp(rs.getString("hp"));
                user.setAddr(rs.getString("addr"));

                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
        return list;
    }

    //단순회원조회
    public User selectUser(String uId) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        User user = new User();

        String sql = "select * from USER where uId=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uId);

            pstmt.execute();

            rs = pstmt.executeQuery();

            if (rs.next()) {
                user.setuId(rs.getString("uId"));
                user.setPw(rs.getString("pw"));
                user.setuName(rs.getString("uName"));
                user.setHp(rs.getString("hp"));
                user.setAddr(rs.getString("addr"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return user;
    }

    //회원추가
    public void insertUser(String uId, String pw, String uName, String hp, String addr) {

        String sql = "insert into USER values(?,?,?,?,?)";

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, uId);
            pstmt.setString(2, uName);
            pstmt.setString(3, pw);
            pstmt.setString(4, hp);
            pstmt.setString(5, addr);

            int n = pstmt.executeUpdate();
            if (n == 1) System.out.println(uId + "님 가입을 환영합니다.\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    //회원삭제
    public void deleteUser(String uId) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "delete from USER where uId=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uId);
            int n = pstmt.executeUpdate();
            if (n == 1) System.out.println("**회원 삭제 완료**\n");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    //회원 수정
//    public void updateUser() {
//        while (true) {
//            System.out.print("수정하고싶은 계정의 아이디 입력 >> ");
//            String uId = sc.nextLine();
//            User user = findByUser(uId);
//            if (user == null) {
//                System.out.println("재입력하세요");
//            } else {
//                System.out.println("1. 비밀번호 수정\t2. 주소 수정\t0. 돌아가기");
//                System.out.print("입력 >> ");
//                int num = Integer.parseInt(sc.nextLine());
//
//                while (true) {
//                    switch (num) {
//                        case 1:
//                            updatePwUser(uId);
//                            return;
//                        case 2:
//                            updateAddrUser(uId);
//                            return;
//                        case 0:
//                            System.out.println("취소합니다.\n");
//                            return;
//                        default:
//                            System.out.println("재입력하세요.\n");
//                    }
//                }
//            }
//        }
//    }

//    //회원 pw 수정
//    public void updatePwUser(String uId) {
//        Connection conn = db.getConnection();
//        PreparedStatement pstmt = null;
//
//        String sql = "update USER set pw=? where uId=?";
//
//        System.out.print("비밀번호 변경 >> ");
//        String pw = sc.nextLine();
//
//        try {
//            pstmt = conn.prepareStatement(sql);
//
//            pstmt.setString(1, pw);
//            pstmt.setString(2, uId);
//
//            int n = pstmt.executeUpdate();
//            if (n == 1) System.out.println("**비밀번호 변경 완료**\n");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            db.dbClose(pstmt, conn);
//        }
//
//    }
//
//    //회원 주소 수정
//    public void updateAddrUser(String uId) {
//        Connection conn = db.getConnection();
//        PreparedStatement pstmt = null;
//
//        String sql = "update USER set addr=? where uId=?";
//
//        System.out.print("주소 변경 >> ");
//        String addr = sc.nextLine();
//
//        try {
//            pstmt = conn.prepareStatement(sql);
//
//            pstmt.setString(1, addr);
//            pstmt.setString(2, uId);
//
//            int n = pstmt.executeUpdate();
//            if (n == 1) System.out.println("**주소 변경 완료**\n");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            db.dbClose(pstmt, conn);
//        }
//
//    }

    //회원 통합 수정
    public void updateUser(User user) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "update USER set pw=?, hp=?, addr=? where uId=?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getPw());
            pstmt.setString(2, user.getHp());
            pstmt.setString(3, user.getAddr());
            pstmt.setString(4, user.getuId());

            int n = pstmt.executeUpdate();
            if (n == 1) System.out.println("**변경 완료**\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    //회원 관리
//    public void managementUser() {
//        while (true) {
//            System.out.println("[회원 관리 시스템]");
//            System.out.println("1. 회원전체조회\t2. 회원상세조회\t3.회원삭제\t4. 회원정보수정\t5.회원가입\t0.종료");
//            System.out.print("입력 >> ");
//            int num = Integer.parseInt(sc.nextLine());
//
//            switch (num) {
//                case 1:
//                    selectAllUser();
//                    break;
//                case 2:
//                    selectUser();
//                    break;
//                case 3:
//                    deleteUser();
//                    break;
//                case 4:
//                    updateUser();
//                    break;
//                case 5:
//                    insertUser();
//                    break;
//                case 0:
//                    System.out.println("프로그램 종료합니다\n");
//                    System.exit(0);
//                default:
//                    System.out.println("재입력하세요");
//            }
//        }
//
//    }


}

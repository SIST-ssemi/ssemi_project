package ssemi.ssemibucks.USER;

import org.springframework.stereotype.Repository;
import ssemi.ssemibucks.DbConnection.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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
    public int idDuplication(String uId) {
        if (findByUser(uId).getuId() == uId) {
            System.out.println("아이디 중복");
            return 1;
        }
        return 0;
    }

    //모든회원조회
    public void selectAllUser() {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from USER order by uName";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();


            if (rs.next()) {
                System.out.println("아이디\t이름\t\t비밀번호\t전화번호\t\t\t주소");
                System.out.println("==================================================");
                do {
                    System.out.println(rs.getString("uId") + "\t" +
                            rs.getString("uName") + "\t" +
                            rs.getString("pw") + "\t" +
                            rs.getString("hp") + "\t" +
                            rs.getString("addr"));
                } while (rs.next());

            } else {
                System.out.println("회원이 없습니다.");
            }
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

    }

    //단순회원조회
    public void selectUser() {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from USER where uId=?";

        while (true) {
            System.out.print("아이디를 입력하세요 >> ");
            String uId = sc.nextLine();

            User user = findByUser(uId);
            if (user == null) {
                System.out.println("재입력하세요");
            } else {

                try {
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, uId);

                    pstmt.execute();

                    rs = pstmt.executeQuery();
                    System.out.println("**내 정보**");
                    System.out.println("아이디\t이름\t\t비밀번호\t전화번호\t\t\t주소");
                    System.out.println("==================================================");
                    while (rs.next()) {
                        System.out.println(rs.getString("uId") + "\t" +
                                rs.getString("uName") + "\t" +
                                rs.getString("pw") + "\t" +
                                rs.getString("hp") + "\t" +
                                rs.getString("addr"));
                    }
                    System.out.println();
                    break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    db.dbClose(pstmt, conn);
                }

            }
        }
    }

    //회원추가
    public void insertUser(String uId,String pw,String uName,String hp, String addr) {
//        String uId = "";
//        while (true) {
//            System.out.print("아이디 입력 >> ");
//            uId = sc.nextLine();
//            User user=findByUser(uId);
//            if(user==null) break;
//            else System.out.println("이미 존재하는 아이디입니다.");
//        }

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
    public void deleteUser() {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "delete from USER where uId=?";

        while (true) {
            System.out.print("삭제하고싶은 계정의 아이디 입력 >> ");
            String uId = sc.nextLine();
            User user = findByUser(uId);
            if (user == null) {
                System.out.println("재입력하세요");
            } else {

                try {
                    pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, uId);

                    int n = pstmt.executeUpdate();
                    if (n == 1) System.out.println("**회원 삭제 완료**\n");
                    break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    db.dbClose(pstmt, conn);
                }
            }
        }
    }

    //회원 수정
    public void updateUser() {
        while (true) {
            System.out.print("수정하고싶은 계정의 아이디 입력 >> ");
            String uId = sc.nextLine();
            User user = findByUser(uId);
            if (user == null) {
                System.out.println("재입력하세요");
            } else {
                System.out.println("1. 비밀번호 수정\t2. 주소 수정\t0. 돌아가기");
                System.out.print("입력 >> ");
                int num = Integer.parseInt(sc.nextLine());

                while (true) {
                    switch (num) {
                        case 1:
                            updatePwUser(uId);
                            return;
                        case 2:
                            updateAddrUser(uId);
                            return;
                        case 0:
                            System.out.println("취소합니다.\n");
                            return;
                        default:
                            System.out.println("재입력하세요.\n");
                    }
                }
            }
        }
    }

    //회원 pw 수정
    public void updatePwUser(String uId) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "update USER set pw=? where uId=?";

        System.out.print("비밀번호 변경 >> ");
        String pw = sc.nextLine();

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, pw);
            pstmt.setString(2, uId);

            int n = pstmt.executeUpdate();
            if (n == 1) System.out.println("**비밀번호 변경 완료**\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }

    }

    //회원 주소 수정
    public void updateAddrUser(String uId) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "update USER set addr=? where uId=?";

        System.out.print("주소 변경 >> ");
        String addr = sc.nextLine();

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, addr);
            pstmt.setString(2, uId);

            int n = pstmt.executeUpdate();
            if (n == 1) System.out.println("**주소 변경 완료**\n");
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



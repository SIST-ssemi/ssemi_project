package ssemi.ssemibucks.USER;

import java.sql.SQLException;
import java.util.Scanner;

public class UserTest {

    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();
        UserService userService = new UserService();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 로그인\t2. 회원가입\t0. 종료");
            int num = Integer.parseInt(sc.nextLine());

            switch (num) {
                case 1:
                    String id = userService.loginUser();
                    if ("admin".equals(id))
                        userService.management();
                    else userService.myPage();
                    break;

                case 2:
                    userService.registerUser();
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    System.exit(0);
                default:
                    System.out.println("재입력하세요.");
            }
        }


    }
}
package ssemi.ssemibucks.USER;

import java.sql.SQLException;

public class UserTest {

    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();
        UserService userService = new UserService();


        userService.management();


    }
}
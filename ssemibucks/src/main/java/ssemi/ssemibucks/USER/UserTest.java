package ssemi.ssemibucks.USER;

import java.sql.SQLException;

public class UserTest {

    public static void main(String[] args) throws SQLException {
        UserDao ud = new UserDao();
        UserService us = new UserService();

         ud.managementUser();

    }
}
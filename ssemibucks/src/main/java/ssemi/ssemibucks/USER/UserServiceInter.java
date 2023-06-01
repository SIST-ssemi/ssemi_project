package ssemi.ssemibucks.USER;

import java.util.List;

public interface UserServiceInter {

    public User findByUser(String uId);
    public List<User> findAllUsers();
    public void insertUser(User user);
    public void deleteUser(String uId);
    public void updateUser(User user);
}

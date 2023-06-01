package ssemi.ssemibucks.USER;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapperInter {
    public User findByUser(String uId);
    public List<User> findAllUsers();
    public void insertUser(User user);
    public void deleteUser(String uId);
    public void updateUser(User user);
}

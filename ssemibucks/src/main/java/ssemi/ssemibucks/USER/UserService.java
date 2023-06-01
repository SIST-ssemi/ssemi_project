package ssemi.ssemibucks.USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;


@Service
public class UserService implements UserServiceInter {
    @Autowired
    UserMapperInter mapperInter;

    //로그인
    public String loginUser(String uId, String pw) throws IOException {
        boolean flag = false;
        User user = new User();
        String str = "";

        user.setuId(uId);
        user.setPw(pw);

        if (mapperInter.findByUser(uId) == null) {
            //System.out.println("아이디가 존재하지 않습니다.\n");
            str = "noId";
        } else if (mapperInter.findByUser(uId).getuId().equals(user.getuId()) && !mapperInter.findByUser(uId).getPw().equals(user.getPw())) {
            //System.out.println("비밀번호가 일치하지 않습니다.\n");
            str = "noPw";
        } else {
            //System.out.println(user.getuId() + "님 환영합니다.\n");
            flag = true;
            str = user.getuId();
        }

        return str;
    }

    //회원가입
    public void registerUser(String uId, String pw, String uName, String hp, String addr) {
        User user = new User();

        user.setuId(uId);
        user.setAddr(addr);
        user.setHp(hp);
        user.setuName(uName);
        user.setPw(pw);

        mapperInter.insertUser(user);
    }

    //마이페이지
    public void myPage(String uId) {
        mapperInter.findByUser(uId);

    }

    @Override
    public User findByUser(String uId) {
        return mapperInter.findByUser(uId);
    }

    @Override
    public List<User> findAllUsers() {
        return mapperInter.findAllUsers();
    }

    @Override
    public void insertUser(User user) {
        mapperInter.insertUser(user);
    }

    @Override
    public void deleteUser(String uId) {
        mapperInter.deleteUser(uId);
    }

    @Override
    public void updateUser(User user) {
        mapperInter.updateUser(user);
    }

    public String idDuplication(String uId) {
        String str = "";
        if (findByUser(uId) == null) {
            str = "사용가능아이디";
        } else {
            str = "중복아이디";
        }
        return str;
    }

}
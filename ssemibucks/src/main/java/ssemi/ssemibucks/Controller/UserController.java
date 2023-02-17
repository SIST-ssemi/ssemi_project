package ssemi.ssemibucks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssemi.ssemibucks.USER.User;
import ssemi.ssemibucks.USER.UserDao;
import ssemi.ssemibucks.USER.UserService;

import java.io.IOException;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(){
            return "login";
    }

    @RequestMapping(value = "loginAction", method = RequestMethod.POST)
    public String loginAction(String uId, String pw) throws IOException {
        User user = new User();
        user.setuId(uId);
        user.setPw(pw);

        UserDao userDao = new UserDao();

        UserService userService = new UserService(userDao);
        userService.loginUser(user.getuId(), user.getPw());

        return "index";
    }

}

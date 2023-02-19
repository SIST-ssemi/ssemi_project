package ssemi.ssemibucks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssemi.ssemibucks.USER.User;
import ssemi.ssemibucks.USER.UserDao;
import ssemi.ssemibucks.USER.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(){
            return "login";
    }

    @RequestMapping(value = "loginAction", method = RequestMethod.POST)
    public String loginAction(String uId, String pw, Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String msg = "";

        User user = new User();
        user.setuId(uId);
        user.setPw(pw);

        UserDao userDao = new UserDao();

        UserService userService = new UserService(userDao);
        if(userService.loginUser(user.getuId(), user.getPw()).equals("noId")) {
            model.addAttribute("msg", "아이디룰 다시 입력해주세요");
            model.addAttribute("url", "login");
            session.setAttribute("uId", null);
            return "alert";
        }

        else if(userService.loginUser(user.getuId(), user.getPw()).equals("noPw")) {
            model.addAttribute("msg", "비밀번호를 다시 입력해주세요");
            model.addAttribute("url", "login");
            session.setAttribute("uId", null);
            return "alert";
        }
        else {
            System.out.println("userId = " + userService.loginUser(user.getuId(), user.getPw()));
            model.addAttribute("msg", user.getuId() +"님, 환영합니다");
            // request.setAttribute("url", "/index");
            model.addAttribute("url", "index");
            session.setAttribute("uId", uId);
            return "alert";
        }
    }

    @GetMapping("/mypage")
    public String mypage(){
        return "mypage";
    }
}

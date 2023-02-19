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

    @GetMapping("/user/login")
    public String login(){
            return "/user/login";
    }

    @GetMapping("/user/logout")
    public String logout(){
        return "/user/logout";
    }

    @RequestMapping(value = "/user/loginAction", method = RequestMethod.POST)
    public String loginAction(String uId, String pw, Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String msg = "";

        User user = new User();
        user.setuId(uId);
        user.setPw(pw);

        UserDao userDao = new UserDao();

        UserService userService = new UserService(userDao);
        if(userService.loginUser(user.getuId(), user.getPw()).equals("noId")) {
            model.addAttribute("msg", "아이디를 다시 입력해주세요");
            model.addAttribute("url", "/user/login");
            session.setAttribute("uId", null);
            return "alert";
        }

        else if(userService.loginUser(user.getuId(), user.getPw()).equals("noPw")) {
            model.addAttribute("msg", "비밀번호를 다시 입력해주세요");
            model.addAttribute("url", "/user/login");
            session.setAttribute("uId", null);
            return "alert";
        }
        else {
            System.out.println("userId = " + userService.loginUser(user.getuId(), user.getPw()));
            model.addAttribute("msg", user.getuId() +"님, 환영합니다");
            model.addAttribute("url", "index");
            session.setAttribute("uId", uId);
            return "alert";
        }
    }

    @GetMapping("/user/register")
    public String register(){
        return "/user/register";
    }

    @RequestMapping(value = "/user/registerAction", method = RequestMethod.POST)
    public String registerAction(String uId,String pw,String uName,String hp,String addr,Model model){

        UserDao userDao=new UserDao();
        UserService userService=new UserService(userDao);
        userService.registerUser(uId,pw,uName,hp,addr);

        model.addAttribute("msg", uId+"님, 환영합니다. 재로그인해주세요");
        model.addAttribute("url", "/user/login");
        return "alert";
    }

    @GetMapping("/user/mypage")
    public String mypage(){
        return "/user/mypage";
    }

    @GetMapping("/user/adminpage")
    public String adminpage(){
        return "/user/adminpage";
    }

}

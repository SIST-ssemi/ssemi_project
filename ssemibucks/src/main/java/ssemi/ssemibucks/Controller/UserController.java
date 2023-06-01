package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ssemi.ssemibucks.USER.User;
import ssemi.ssemibucks.USER.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/user/user_login")
    public String login() {
        return "/user/user_login";
    }

    @GetMapping(value = "/user/user_logout")
    public String logout(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String uId = (String) session.getAttribute("uId");

        model.addAttribute("msg", uId + "님 로그아웃하셨습니다.");
        model.addAttribute("url", "/user/user_sessioninval");

        return "alert";
    }

    @GetMapping("/user/user_sessioninval")
    public String user_sessioninval() {
        return "/user/user_sessioninval";
    }

    @RequestMapping(value = "/user/user_loginAction", method = RequestMethod.POST)
    public String loginAction(String uId, String pw, Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String msg = "";

        User user = new User();
        user.setuId(uId);
        user.setPw(pw);

        if (service.loginUser(user.getuId(), user.getPw()).equals("noId")) {
            model.addAttribute("msg", "아이디를 다시 입력해주세요");
            model.addAttribute("url", "/user/user_login");
            session.setAttribute("uId", null);
            return "alert";
        } else if (service.loginUser(user.getuId(), user.getPw()).equals("noPw")) {
            model.addAttribute("msg", "비밀번호를 다시 입력해주세요");
            model.addAttribute("url", "/user/user_login");
            session.setAttribute("uId", null);
            return "alert";
        } else {
            //System.out.println("userId = " + service.loginUser(user.getuId(), user.getPw()));
            model.addAttribute("msg", user.getuId() + "님, 환영합니다");
            model.addAttribute("url", "/index");
            session.setAttribute("uId", uId);
            return "alert";
        }
    }

    @GetMapping("/user/user_chkId")
    public String chkId() {
        return "/user/user_chkId";
    }

    @RequestMapping(value = "/user/user_chkIdAction", method = RequestMethod.POST)
    public String chkIdAction(String chkId, Model model) {

        String result = service.idDuplication(chkId);

        if (result.equals("중복아이디")) {
            model.addAttribute("msg", "중복된 아이디입니다. 다시 입력해주세요.");
            return "alert_idcheck";
        } else {
            model.addAttribute("msg", "사용가능한 아이디입니다.");
            return "alert_idcheck";
        }

    }

    @GetMapping("/user/user_register")
    public String register() {
        return "/user/user_register";
    }

    @RequestMapping(value = "/user/user_registerAction", method = RequestMethod.POST)
    public String registerAction(String uId, String pw, String uName, String hp, String addr, Model model) {

        service.registerUser(uId, pw, uName, hp, addr);

        model.addAttribute("msg", uId + "님, 환영합니다. 재로그인해주세요");
        model.addAttribute("url", "/user/user_login");
        return "alert";
    }

    @GetMapping("/user/user_mypage")
    public ModelAndView mypage(HttpSession session) {
        ModelAndView mview = new ModelAndView();

        String uId = (String) session.getAttribute("uId");

        mview.addObject("user", service.findByUser(uId));
        mview.setViewName("/user/user_mypage");

        return mview;
    }

    @RequestMapping("/user/user_signout")
    public String user_signout() {
        return "/user/user_signout";
    }

    @RequestMapping(value = "/user/user_deleteAction", method = RequestMethod.GET)
    public String deleteAction(@RequestParam String uId, Model model) {
        service.deleteUser(uId);

        model.addAttribute("msg", uId + "님, 탈퇴 처리되었습니다.");
        model.addAttribute("url", "/user/user_signout");
        return "alert";
    }

    @GetMapping("/user/user_update")
    public ModelAndView userupdate(HttpSession session) {
        ModelAndView mview = new ModelAndView();

        String uId = (String) session.getAttribute("uId");

        mview.addObject("user", service.findByUser(uId));
        mview.setViewName("/user/user_update");

        return mview;
    }

    @RequestMapping(value = "/user/user_updateAction", method = RequestMethod.POST)
    public String updateAction(@RequestParam String uId, String pw, String hp, String addr, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        User user = service.findByUser(uId);
        user.setPw(pw);
        user.setHp(hp);
        user.setAddr(addr);

        service.updateUser(user);

        model.addAttribute("msg", uId + "님, 수정완료되었습니다.");
        model.addAttribute("url", "/user/user_mypage");
        return "/alert";
    }

}
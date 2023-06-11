package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ssemi.ssemibucks.USER.User;
import ssemi.ssemibucks.USER.UserService;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class UserRestController {

    @Autowired
    UserService service;
    @GetMapping("/user/userdata")
    public User mypage(HttpSession session) {

        String loginId = (String) session.getAttribute("loginId");

        return service.findByUser(loginId);

    }

    @PostMapping("/user/loginaction")
    public String loginaction(@RequestParam String uId, HttpSession session) {
        //System.out.println(uId);
        session.setAttribute("loginId", uId);
        session.getAttribute("loginId");

        return uId;
    }

    @PostMapping("/user/registeraction")
    public void registeraction(@RequestBody User newUser) {
        service.registerUser(newUser);
    }


}

package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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

        String uId = (String) session.getAttribute("uId");

        return service.findByUser(uId);

    }

    @PostMapping("/user/loginaction")
    public void loginaction(String uId, String pw, HttpSession session){

        session.setAttribute("uId",uId);

    }

}

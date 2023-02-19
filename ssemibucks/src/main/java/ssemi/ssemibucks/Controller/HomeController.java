package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssemi.ssemibucks.USER.User;
import ssemi.ssemibucks.USER.UserService;

//@Controller
public class TestController {

<<<<<<< HEAD
//    private final UserService userService;
//
//    @Autowired
//    public TestController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping(value = "/login")
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping("/register")
//    public String register() {
//        return "register";
//    }
//
//    @RequestMapping("/mypage")
//    public String mypage() {
//        return "mypage";
//    }
//
//    @RequestMapping("/adminpage")
//    public String adminpage() {
//        return "adminpage";
//    }
//
//    @RequestMapping("/product_list")
//    public String pList() {
//        return "product_list";
//    }
//
//    @RequestMapping("/product_detail")
//    public String pDetail() {
//        return "product_detail";
//    }
//
//    @RequestMapping("/navbar")
//    public String navbar() {
//        return "navbar";
//    }
=======
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/mypage")
    public String mypage(){
        return "mypage";
    }

    @RequestMapping("/adminpage")
    public String adminpage(){
        return "adminpage";
    }

    @RequestMapping("/navbar")
    public String navbar() {
        return "navbar";
    }
>>>>>>> abc95b5671b59d9b01ed0b30dead766d96dd298f

}

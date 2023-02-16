package ssemi.ssemibucks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("/register.html")
    public String register(){
        return "register";
    }

    @RequestMapping("/mypage.html")
    public String mypage(){
        return "mypage";
    }

    @RequestMapping("/adminpage.html")
    public String adminpage(){
        return "adminpage";
    }

    @RequestMapping("/product_list.html")
    public String pList() {
        return "product_list";
    }

    @RequestMapping("/product_detail.html")
    public String pDetail() {
        return "product_detail";
    }

    @RequestMapping("/navbar.html")
    public String navbar() {
        return "navbar";
    }

}

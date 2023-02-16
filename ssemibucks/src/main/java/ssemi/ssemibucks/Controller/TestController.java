package ssemi.ssemibucks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

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

    @RequestMapping("/product_list")
    public String pList() {
        return "product_list";
    }

    @RequestMapping("/product_detail")
    public String pDetail() {
        return "product_detail";
    }

    @RequestMapping("/navbar")
    public String navbar() {
        return "navbar";
    }

}

package ssemi.ssemibucks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/adminpage")
    public String adminpage() {
        return "/admin/adminpage";
    }
}

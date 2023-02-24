package ssemi.ssemibucks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssemi.ssemibucks.USER.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @GetMapping("/admin/admin_adminpage")
    public String adminpage() {
        return "/admin/admin_adminpage";
    }

    @GetMapping("/admin/admin_uManagement")
    public String uManagement() {
        return "/admin/admin_uManagement";
    }

    @RequestMapping("/alertnReferrer")
    public String admin_alertKickout() {
        return "/alertnReferrer";
    }

    @RequestMapping(value = "/admin/admin_userKickoutAction", method = RequestMethod.GET)
    public String deleteAction(@RequestParam String uId, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();
        userDao.deleteUser(uId);

        model.addAttribute("msg", uId + "님을 탈퇴 처리했습니다.");
        return "/alertnReferrer";
    }
}

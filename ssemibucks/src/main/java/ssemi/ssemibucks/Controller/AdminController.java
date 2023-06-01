package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ssemi.ssemibucks.USER.User;
import ssemi.ssemibucks.USER.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserService u_service;

    @GetMapping("/admin/admin_adminpage")
    public String adminpage() {
        return "/admin/admin_adminpage";
    }

    @GetMapping("/admin/admin_uManagement")
    public ModelAndView uManagement(HttpSession session) {
        ModelAndView mview=new ModelAndView();
        String uId = (String) session.getAttribute("uId");

        List<User> userList=u_service.findAllUsers();
        mview.addObject("userList",userList);

        mview.setViewName("/admin/admin_uManagement");

        return mview;
    }

    @RequestMapping("/alertnReferrer")
    public String admin_alertKickout() {
        return "/alertnReferrer";
    }

    @RequestMapping(value = "/admin/admin_userKickoutAction", method = RequestMethod.GET)
    public String deleteAction(@RequestParam String uId, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        //UserDao userDao = new UserDao();
        u_service.deleteUser(uId);

        model.addAttribute("msg", uId + "님을 탈퇴 처리했습니다.");
        return "/alertnReferrer";
    }
}

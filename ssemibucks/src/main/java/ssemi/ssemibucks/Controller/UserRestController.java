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
    public User mypage(@RequestParam String uId) {
        return service.findByUser(uId);

    }

    @PostMapping("/user/loginaction")
    public String loginaction(@RequestParam String uId, @RequestParam String pw) {

        String msg="";

        if(service.findByUser(uId)!=null&&service.findByUser(uId).getPw().equals(pw)){
            msg= "ok";
        } else{
            msg= "no";
        }

        return msg;
    }

    @PostMapping("/user/registeraction")
    public void registeraction(@RequestBody User newUser) {
        service.registerUser(newUser);
    }

    @PostMapping("/user/updateaction")
    public void updateaction(@RequestBody User updateUser) {
        System.out.println(updateUser.getuId());
        service.updateUser(updateUser);
    }

    @PostMapping("/user/deleteaction")
    public String deleteaction(@RequestParam String uId) {
        System.out.println(uId);
        service.deleteUser(uId);

        return uId;
    }


}

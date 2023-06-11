package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ssemi.ssemibucks.USER.User;
import ssemi.ssemibucks.USER.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AdminRestController {

    @Autowired
    UserService u_service;

    @GetMapping("/umanagement/list")
    public List<User> userList() {
        return u_service.findAllUsers();
    }


    @PostMapping("/umanagement/delete")
    public String deleteUser(@RequestBody Map<String, List<User>> deleteusers) {
        String deleteIds = "";

        List<User> delUsers = deleteusers.get("delUsers");

        for (User deluser : delUsers) {
            String delUserId = deluser.getuId();
            u_service.deleteUser(delUserId);

            deleteIds += delUserId + ",";
        }

        return deleteIds.substring(0, deleteIds.length() - 1);
    }
}

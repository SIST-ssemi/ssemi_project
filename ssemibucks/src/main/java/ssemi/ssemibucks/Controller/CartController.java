package ssemi.ssemibucks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/cart/cart_list")
    public String cart_list() {
        return "/cart/cart_list";
    }
}

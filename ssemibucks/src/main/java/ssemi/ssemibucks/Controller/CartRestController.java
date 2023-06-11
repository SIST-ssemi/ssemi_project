package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ssemi.ssemibucks.CART.Cart;
import ssemi.ssemibucks.CART.CartService;
import ssemi.ssemibucks.USER.User;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CartRestController {

    @Autowired
    CartService service;

    @GetMapping("/cart/list")
    public List<Cart> cartList(@RequestParam String uId) {
        return service.getAllCartsOfUser(uId);

    }

    @PostMapping("/cart/delete")
    public int deleteUser(@RequestBody Map<String, List<Cart>> deletecarts) {

        List<Cart> delcarts = deletecarts.get("delcarts");

        for (Cart delcart : delcarts) {
            String delCartId = delcart.getCId();
            service.deleteOfCart(delCartId);

        }

        return delcarts.size();
    }


}

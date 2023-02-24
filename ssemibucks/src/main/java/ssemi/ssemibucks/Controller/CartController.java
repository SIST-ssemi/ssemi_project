package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssemi.ssemibucks.CART.CartService;
import ssemi.ssemibucks.PRODUCT.Product;
import ssemi.ssemibucks.PRODUCT.ProductService;
import ssemi.ssemibucks.USER.User;
import ssemi.ssemibucks.USER.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {
    private final ProductService productService;
    private final CartService cartService;
    private final UserDao userDao;

    @Autowired
    public CartController(CartService cartService, ProductService productService, UserDao userDao) {
        this.cartService = cartService;
        this.productService = productService;
        this.userDao = userDao;
    }


    @GetMapping("/cart/cart_list")
    public String cart_list() {
        return "/cart/cart_list";
    }

    @RequestMapping(value = "/cart/cart_insertAction", method = RequestMethod.POST)
    public String cartInsert(@RequestParam String pId, int cQTY, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        Product product = productService.selectProduct(pId);
        String uId = (String) session.getAttribute("uId");

        User user = userDao.findByUser(uId);

        if(user == null) {
            model.addAttribute("msg",  "로그인이 필요합니다");
            model.addAttribute("url", "/user/user_login");
        } else {
            cartService.registerCart(user.getuId(), pId, cQTY);

            model.addAttribute("msg", "장바구니에 \\'" + product.getpName() + "\\'을/를 추가하였습니다");
            model.addAttribute("url", "/cart/cart_list");
        }

        return "/alert";
    }
}

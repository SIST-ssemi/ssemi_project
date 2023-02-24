package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssemi.ssemibucks.CART.Cart;
import ssemi.ssemibucks.CART.CartService;
import ssemi.ssemibucks.PRODUCT.Product;
import ssemi.ssemibucks.PRODUCT.ProductService;
import ssemi.ssemibucks.USER.User;
import ssemi.ssemibucks.USER.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

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
    public String cart_list(@RequestParam String uId, Model model) throws SQLException {
        List<Cart> carts = cartService.AllCart(uId);
        model.addAttribute("carts", carts);

        return "/cart/cart_list";
    }

    @RequestMapping(value = "/cart/cart_insertAction", method = RequestMethod.POST)
    public String cartInsert(String pId, int cQTY, Model model, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        String uId = (String)session.getAttribute("uId");

        Product product = productService.selectProduct(pId);
        Cart cart = cartService.getCart(uId, pId);

        System.out.println(uId + ", //" + pId + "/");

        if(uId == null) {
            model.addAttribute("msg",  "로그인이 필요합니다");
            model.addAttribute("url", "/user/user_login");

            return "/alert";
        } else {
            if(cartService.getCart(uId, pId) == null) {
                cartService.registerCart(uId, pId, cQTY);

                model.addAttribute("msg", "장바구니에 \\'" + product.getpName() + "\\'을/를 추가하였습니다");
                model.addAttribute("url", "/cart/cart_list");
            } else {
                cQTY = cart.getcQty() + 1;
                cartService.registerCart(uId, pId, cQTY);

                model.addAttribute("msg", "장바구니에 \\'" + product.getpName() + "\\'을/를 추가하였습니다");
                model.addAttribute("url", "/cart/cart_list?uId=" + uId);
            }
        }

        return "/alert";
    }

    @RequestMapping(value = "/cart/cart_updateAction", method = RequestMethod.POST)
    public String cartUpdate(String cId, String pName, int cQTY, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(cId + ", " + pName + ", " + cQTY);
        cartService.modifyCart(cId, cQTY);

        model.addAttribute("msg", "\\'" + pName + "\\'의 수량을 변경하였습니다");
        model.addAttribute("url", "/cart/cart_list?uId=" + (String)session.getAttribute("uId"));

        return "/alert";
    }
}

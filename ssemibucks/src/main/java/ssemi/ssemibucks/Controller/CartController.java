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
import ssemi.ssemibucks.CART.CartDao;
import ssemi.ssemibucks.PRODUCT.ProductDao;
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
        String uId = (String) session.getAttribute("uId");

        Product product = productService.selectProduct(pId);
        Cart cart = cartService.getCart(uId, pId);
        String cId = cart.getcId();

        if (uId == null) {
            model.addAttribute("msg", "???????????? ???????????????");
            model.addAttribute("url", "/user/user_login");

            return "/alert";
        } else {
            if (cId == null) {
                cartService.registerCart(uId, pId, cQTY);

                model.addAttribute("msg", "??????????????? \\'" + product.getpName() + "\\'???/??? ?????????????????????");
                model.addAttribute("url", "/cart/cart_list?uId=" + uId);
            } else {
                cQTY = cart.getcQty() + cQTY;
                cartService.modifyCart(cart.getcId(), cQTY);

                model.addAttribute("msg", "??????????????? \\'" + product.getpName() + "\\'???/??? ?????????????????????");
                model.addAttribute("url", "/cart/cart_list?uId=" + uId);
            }
        }

        return "/alert";
    }

    @RequestMapping(value = "/cart/cart_updateAction", method = RequestMethod.POST)
    public String cartUpdate(String uId, String pId, int cQTY, Model model) throws SQLException {
        Cart cart = cartService.getCart(uId, pId);
        String cId = cart.getcId();

        System.out.println(cId + ", " + cart.getpName() + ", " + cQTY);

        cartService.modifyCart(cId, cQTY);

        model.addAttribute("msg", "\\'" + cart.getpName() + "\\'??? ????????? ?????????????????????");
        model.addAttribute("url", "/cart/cart_list?uId=" + uId);

        return "/alert";
    }


    @RequestMapping(value = "/cart/cart_delete", method = RequestMethod.GET)
    public String cart_delete(@RequestParam String cId, Model model) {
        CartDao cartDao = new CartDao();
        ProductDao productDao = new ProductDao();

        Cart cart = cartDao.findByCart(cId);

        Product product = productDao.findBypId(cart.getpId());

        cartDao.deleteCart(cId);

        model.addAttribute("msg", product.getpName() + "???/??? ?????????????????? ?????????????????????.");
        return "/alertnReferrer";

    }
}

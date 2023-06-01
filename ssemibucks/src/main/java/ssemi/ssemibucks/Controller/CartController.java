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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;


@Controller
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @GetMapping("/cart/cart_list")
    public String cart_list(Model model, HttpSession session) {
        String uId = (String)session.getAttribute("uId");
        List<Cart> carts = cartService.getAllCartsOfUser(uId);
        model.addAttribute("carts", carts);

        return "/cart/cart_list";
    }

    @RequestMapping(value = "/cart/cart_insertAction", method = RequestMethod.POST)
    public String cartInsert(String pId, int cQTY, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String uId = (String)session.getAttribute("uId");

        Product product = productService.getProductByPId(pId);
        Cart cart = cartService.isDuplicationProduct(uId, pId);

        if(uId == null) {
            model.addAttribute("msg",  "로그인이 필요합니다");
            model.addAttribute("url", "/user/user_login");

            return "/alert";
        } else {
            if(cart == null) {
                Cart cart2 = new Cart();

                cart2.setUId(uId);
                cart2.setPId(pId);
                cart2.setCQTY(cQTY);

                cartService.insertOfCart(cart2);
            } else {
                cQTY = cart.getCQTY() + cQTY;
                cartService.updateOfCart(cart.getCId(), cQTY);
            }

            model.addAttribute("msg", "장바구니에 \\'" + product.getPName() + "\\'을/를 추가하였습니다");
            model.addAttribute("url", "/cart/cart_list?uId=" + uId);
        }

        return "/alert";
    }

    @RequestMapping(value = "/cart/cart_updateAction", method = RequestMethod.POST)
    public String cartUpdate(String uId, String pId, int cQTY, Model model) throws SQLException {
        Cart cart = cartService.isDuplicationProduct(uId, pId);
        String cId = cart.getCId();

        cartService.updateOfCart(cId, cQTY);

        model.addAttribute("msg", "\\'" + cart.getPName() + "\\'의 수량을 변경하였습니다");
        model.addAttribute("url", "/cart/cart_list?uId=" + uId);

        return "/alert";
    }

    @RequestMapping(value = "/cart/cart_delete", method = RequestMethod.GET)
    public String cart_delete(@RequestParam String cId, Model model) {
        Cart cart = cartService.findByCart(cId);
        Product product = productService.isDuplicationPId(cart.getPId());

        cartService.deleteOfCart(cId);

        model.addAttribute("msg", product.getPName() + "이/가 장바구니에서 삭제되었습니다.");
        return "/alertnReferrer";

    }
}

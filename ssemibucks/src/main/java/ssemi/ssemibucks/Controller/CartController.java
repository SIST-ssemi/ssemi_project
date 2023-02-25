package ssemi.ssemibucks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssemi.ssemibucks.CART.Cart;
import ssemi.ssemibucks.CART.CartDao;
import ssemi.ssemibucks.PRODUCT.Product;
import ssemi.ssemibucks.PRODUCT.ProductDao;

@Controller
public class CartController {

    @GetMapping("/cart/cart_list")
    public String cart_list() {
        return "/cart/cart_list";
    }


    @RequestMapping(value = "/cart/cart_delete", method = RequestMethod.GET)
    public String cart_delete(@RequestParam String cId, Model model) {
        CartDao cartDao = new CartDao();
        ProductDao productDao=new ProductDao();

        Cart cart = cartDao.findByCart(cId);

        Product product=productDao.findBypId(cart.getpId());

        cartDao.deleteCart(cId);

        model.addAttribute("msg", product.getpName() + "이/가 장바구니에서 삭제되었습니다.");
        return "/alertnReferrer";
    }
}

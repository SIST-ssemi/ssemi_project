package ssemi.ssemibucks.CART;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssemi.ssemibucks.PRODUCT.Product;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

@Service
public class CartService {

    private final CartDao cartDao;
    Scanner sc = new Scanner(System.in);

    @Autowired
    public CartService(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    // 장바구니 조회
    public Vector<Cart> AllCart(String uId) throws SQLException {
        System.out.println("장바구니 조회\n");
        return cartDao.selectCart(uId);
    }

    // 장바구니 상품 존재 여부 조회 - 수정
    public Cart getCart(String uId, String pId) throws SQLException {
        System.out.println("장바구니 상품 존재 여부 조회\n");
        return cartDao.findBypId(uId, pId);
    }

    // 장바구니 등록
    public void registerCart(String uId, String pId, int cQTY) {
        System.out.println("장바구니 등록\n");
        cartDao.insertCart(uId, pId, cQTY);
    }

//    // 장바구니 삭제
//    public void removeCart() {
//        System.out.println("장바구니 삭제\n");
//            cartDao.deleteCart(pId);
//    }
//

    // 장바구니 수정
    public void modifyCart(String cId, int cQTY) {
        System.out.println("장바구니 수정\n");
        cartDao.updateCart(cId, cQTY);
    }
}

package ssemi.ssemibucks.CART;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssemi.ssemibucks.PRODUCT.Product;
import ssemi.ssemibucks.PRODUCT.ProductDao;

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

//    //장바구니 목록 조회
//    public Vector<Cart> allCart() throws SQLException {
//        System.out.println("장바구니 목록 조회\n");
//        return cartDao.selectCart();
//    }

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
//    // 장바구니 수정
//    public void modifyCart() {
//        System.out.println("장바구니 수정\n");
//
//        String pId;
//        int num, cQTY;
//
//        System.out.print("장바구니에서 수정할 상품 아이디 입력 : ");
//        pId = sc.nextLine();
//        System.out.println();
//
//        Cart cart = cartDao.findBypId(pId);
//        if (cart == null) {
//            System.out.println("장바구니 - 해당 상품 정보 없음\n\n");
//            return;
//        }
//
//        String pName = cart.getpName();
//
//        System.out.println("장바구니 - [" + pName + "]의 개수를 수정하시겠습니까?  1:yes  2:no");
//        System.out.print("번호 입력 : ");
//        num = Integer.parseInt(sc.nextLine());
//        System.out.println();
//
//        if (num == 1) {
//            System.out.print("장바구니 - [" + pName + "]의 수정할 개수 입력 : ");
//            cQTY = Integer.parseInt(sc.nextLine());
//            System.out.println();
//        } else if (num == 2) {
//            System.out.println("장바구니 - [" + pName + "]의 수정 취소\n\n");
//            return;
//        } else {
//            System.out.println("해당 번호 없음\n\n");
//            return;
//        }
//
//        cartDao.updateCart(pId, pName, cQTY);
//    }
}

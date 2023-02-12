package ssemi.ssemibucks.CART;

public class CartService {
    CartDao cartDao = new CartDao();

    //장바구니 목록조회
    public void allCart(){
        System.out.println("[장바구니 목록]");
        cartDao.selectCart();
    }
}

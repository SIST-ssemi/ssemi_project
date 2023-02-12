package ssemi.ssemibucks.CART;

public class CartTest {

    public static void main(String[] args) {
        CartDao cartDao = new CartDao();
        CartService cartService = new CartService();

        cartService.allCart();

    }
}


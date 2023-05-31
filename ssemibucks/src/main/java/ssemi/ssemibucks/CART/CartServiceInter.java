package ssemi.ssemibucks.CART;

import java.util.HashMap;
import java.util.List;

public interface CartServiceInter {

    public List<Cart> selectCart(String uId);
    public void insertCart(Cart cart);
    public Cart findByCart(String cId);
    public void deleteCart(String cId);
    public void updateCart(String cId, int cQty);
    public Cart findBypId(String uId, String pId);

}

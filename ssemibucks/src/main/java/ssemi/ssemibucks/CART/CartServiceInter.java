package ssemi.ssemibucks.CART;

import java.util.HashMap;
import java.util.List;

public interface CartServiceInter {

    public List<Cart> getAllCartsOfUser(String uId);
    public void insertOfCart(Cart cart);
    public Cart findByCart(String cId);
    public void deleteOfCart(String cId);
    public void updateOfCart(String cId, int cQTY);
    public Cart isDuplicationProduct(String uId, String pId);

}

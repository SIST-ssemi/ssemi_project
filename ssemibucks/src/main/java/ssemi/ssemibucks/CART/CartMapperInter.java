package ssemi.ssemibucks.CART;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CartMapperInter {

    public List<Cart> getAllCartsOfUser(String uId);
    public void insertOfCart(Cart cart);
    public Cart findByCart(String cId);
    public void deleteOfCart(String cId);
    public void updateOfCart(HashMap<String, Object> map);
    public Cart isDuplicationProduct(HashMap<String, Object> map);

}

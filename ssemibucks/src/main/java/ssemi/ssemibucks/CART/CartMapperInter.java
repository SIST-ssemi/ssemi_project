package ssemi.ssemibucks.CART;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CartMapperInter {

    public List<Cart> selectCart(String uId);
    public void insertCart(Cart cart);
    public Cart findByCart(String cId);
    public void deleteCart(String cId);
    public void updateCart(HashMap<String, Object> map);
    public Cart findBypId(HashMap<String, Object> map);

}

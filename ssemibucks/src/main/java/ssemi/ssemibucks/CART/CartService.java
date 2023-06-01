package ssemi.ssemibucks.CART;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssemi.ssemibucks.PRODUCT.Product;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

@Service
public class CartService implements CartServiceInter {

    @Autowired
    CartMapperInter mapper;

    // 장바구니 조회
    public List<Cart> getAllCartsOfUser(String uId)  {
        return mapper.getAllCartsOfUser(uId);
    }

    // 장바구니 등록
    public void insertOfCart(Cart cart) {
        mapper.insertOfCart(cart);
    }

    @Override
    public Cart findByCart(String cId) {
        return mapper.findByCart(cId);
    }

    // 장바구니 삭제
    @Override
    public void deleteOfCart(String cId) {
        mapper.deleteOfCart(cId);
    }

    // 장바구니 수정
    @Override
    public void updateOfCart(String cId, int cQTY) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("cId", cId);
        map.put("cQTY", cQTY);

        mapper.updateOfCart(map);
    }

    // 장바구니 상품 존재 여부 조회
    @Override
    public Cart isDuplicationProduct(String uId, String pId) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("uId", uId);
        map.put("pId", pId);

        return mapper.isDuplicationProduct(map);
    }

}

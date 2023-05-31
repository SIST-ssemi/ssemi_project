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
    public List<Cart> selectCart(String uId)  {
        System.out.println("장바구니 조회\n");
        return mapper.selectCart(uId);
    }

    // 장바구니 등록
    public void insertCart(Cart cart) {
        System.out.println("장바구니 등록\n");
        mapper.insertCart(cart);
    }

    @Override
    public Cart findByCart(String cId) {
        return mapper.findByCart(cId);
    }

    // 장바구니 삭제
    @Override
    public void deleteCart(String cId) {
        System.out.println("장바구니 삭제\n");
        mapper.deleteCart(cId);
    }

    // 장바구니 수정
    @Override
    public void updateCart(String cId, int cQty) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("cId", cId);
        map.put("cQty", cQty);

        System.out.println("장바구니 수정\n");
        mapper.updateCart(map);
    }

    // 장바구니 상품 존재 여부 조회
    @Override
    public Cart findBypId(String uId, String pId) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("uId", uId);
        map.put("pId", pId);

        return mapper.findBypId(map);
    }

}

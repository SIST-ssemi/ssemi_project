package ssemi.ssemibucks.PRODUCT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

@Service
public class ProductService implements ProductServiceInter{

    @Autowired
    public ProductMapperInter mapper;

    // 전체 상품 조회
    public List<Product> selectAllProduct() {
        System.out.println("전체 상품 조회\n");
        return mapper.selectAllProduct();
    }

    // 카테고리별 상품 조회
    public List<Product> selectCategoryProduct(String category) {
        System.out.println("카테고리별 상품 조회\n");
        return mapper.selectCategoryProduct(category);
    }

    // 상세 상품 조회
    public Product selectProduct(String pId) {
        System.out.println("상세 상품 조회\n");
        return mapper.selectProduct(pId);
    }

    // 상품 등록
    public void insertProduct(Product product) {
        System.out.println("상품 등록\n");
        mapper.insertProduct(product);
    }

    // 상품 삭제
    public void deleteProduct(String pId) {
        System.out.println("상품 삭제\n");
        mapper.deleteProduct(pId);
    }

    // 상품 수정
    public void updateProduct(Product product) {
        System.out.println("상품 수정\n");
        mapper.updateProduct(product);
    }

    // 상품 아이디 존재 여부 확인 - 중복 상품 등록 방지
    public Product findBypId(String pId) {
        System.out.println("상품 아이디 존재 여부 확인\n");
        return mapper.findBypId(pId);
    }

    // 상품 아이디 무조건 p + 숫자 4자리
    public boolean pIdCheck(String pId) {
        return pId.matches("^p[0-9]{4}");
    }

    public String idDuplication(String pId) {
        if(mapper.findBypId(pId) == null) {
            System.out.println("이미 존재하는 상품 아이디\n\n");
            return "already";
        } else {
            // 상품 아이디 p + 숫자 4자리 체크
            if (!pIdCheck(pId)) {
                System.out.println("상품 아이디는 p + 숫자 4자리로 생성 가능합니다.\n");
                return "false";
            }
            else
                return "true";
        }
    }
}
package ssemi.ssemibucks.PRODUCT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.Vector;
@Service
public class ProductService {
    private final ProductDao productDao;
    Scanner sc = new Scanner(System.in);

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    // 전체 상품 조회
    public Vector<Product> allProduct() {
        System.out.println("전체 상품 조회\n");
        return productDao.selectAllProduct();
    }

    // 상세 상품 조회
    public Product selectProduct(String pId) {
        System.out.println("전체 상품 조회\n");
        return productDao.selectProduct(pId);
    }

    // 상품 등록
    public void registerProduct(Product product) {
        System.out.println("상품 등록\n");
        productDao.insertProduct(product);
    }

    // 상품 삭제
    public void removeProduct(Product product) {
        System.out.println("상품 삭제\n");
        productDao.deleteProduct(product);
    }

    // 상품 수정
    public void modifyProduct(Product product) {
        System.out.println("상품 수정\n");
        productDao.updateProduct(product);
    }

    // 상품 아이디 무조건 p + 숫자 4자리
    private boolean pIdCheck(String pId) {
        return pId.matches("^p[0-9]{4}");
    }

    public String validateDuplicatePId(Product product) {
        if(productDao.findBypId(product.getpId()) == null) {
            System.out.println("이미 존재하는 상품 아이디\n\n");
            return "already";
        } else {
            // 상품 아이디 p + 숫자 4자리 체크
            if (!pIdCheck(product.getpId())) {
                System.out.println("상품 아이디는 p + 숫자 4자리로 생성 가능합니다.\n");
                return "false";
            }
            else
                return "true";
        }
    }
}
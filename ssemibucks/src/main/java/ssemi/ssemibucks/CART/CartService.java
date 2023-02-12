package ssemi.ssemibucks.CART;

import ssemi.ssemibucks.PRODUCT.Product;
import ssemi.ssemibucks.PRODUCT.ProductDao;

import java.util.Scanner;

public class CartService {

    private final CartDao cartDao;
    private final ProductDao productDao;
    Scanner sc = new Scanner(System.in);

    public CartService(CartDao cartDao, ProductDao productDao) {
        this.cartDao = cartDao;
        this.productDao = productDao;
    }
    
    // 장바구니 등록
    public void registerCart() {
        System.out.println("장바구니 등록\n");

        String pId;
        int cQTY, num = 0;

        System.out.print("장바구니에 추가할 상품 아이디 입력 : ");
        pId = sc.nextLine();
        System.out.println();

        // PRODUCT에 존재하는지 확인
        Product product = productDao.findBypId(pId);
        if (product == null) {
            System.out.println("입력한 상품이 상품 목록에 존재하지 않음\n\n");
            return;
        }

        Cart cart = cartDao.findBypId(pId);
        if (cart != null) {
            System.out.println("이미 장바구니에 해당 상품이 존재합니다. 수량을 추가하시겠습니까?  1:yes  2:no");
            System.out.print("번호 입력 : ");
            num = Integer.parseInt(sc.nextLine());
            System.out.println();

            if (num == 2) {
                System.out.println("장바구니 추가 취소\n\n");
                return;
            } else if (num != 1) {
                System.out.println("해당 번호 없음\n\n");
                return;
            }
        }
        String pName = product.getpName();
        System.out.print("장바구니 - 추가할 [" + pName + "]의 개수 입력 : ");
        cQTY = Integer.parseInt(sc.nextLine());
        System.out.println();

        if (num == 1) {
            cQTY += cart.getcQty();
            System.out.println(cQTY + ", " + cart.getcQty());
            cartDao.updateCart(pId, pName, cQTY);
        } else
            cartDao.insertCart(product, cQTY);
    }

    // 장바구니 삭제
    public void removeCart() {
        System.out.println("장바구니 삭제\n");

        String pId;
        int num;

        System.out.print("장바구니에서 삭제할 상품 아이디 입력 : ");
        pId = sc.nextLine();
        System.out.println();

        Cart cart = cartDao.findBypId(pId);

        // 상품 아이디 존재 여부 확인
        if (cart == null) {
            System.out.println("장바구니 - 해당 상품 정보 없음\n\n");
            return;
        }

        String pName = cart.getpName();
        System.out.println("장바구니 - [" + pName + "] 삭제하시겠습니까?  1:yes  2:no");
        System.out.print("번호 입력 : ");
        num = Integer.parseInt(sc.nextLine());
        System.out.println();

        if (num == 1) {
            cartDao.deleteCart(pId, pName);
        } else if (num == 2) {
            System.out.println("장바구니 삭제 취소\n\n");
            return;
        } else {
            System.out.println("해당 번호 없음\n\n");
            return;
        }

    }

    // 장바구니 수정
    public void modifyCart() {
        System.out.println("장바구니 수정\n");

        String pId;
        int num, cQTY;

        System.out.print("장바구니에서 수정할 상품 아이디 입력 : ");
        pId = sc.nextLine();
        System.out.println();

        Cart cart = cartDao.findBypId(pId);
        if (cart == null) {
            System.out.println("장바구니 - 해당 상품 정보 없음\n\n");
            return;
        }

        String pName = cart.getpName();

        System.out.println("장바구니 - [" + pName + "]의 개수를 수정하시겠습니까?  1:yes  2:no");
        System.out.print("번호 입력 : ");
        num = Integer.parseInt(sc.nextLine());
        System.out.println();

        if (num == 1) {
            System.out.print("장바구니 - [" + pName + "]의 수정할 개수 입력 : ");
            cQTY = Integer.parseInt(sc.nextLine());
            System.out.println();
        } else if (num == 2) {
            System.out.println("장바구니 - [" + pName + "]의 수정 취소\n\n");
            return;
        } else {
            System.out.println("해당 번호 없음\n\n");
            return;
        }

        cartDao.updateCart(pId, pName, cQTY);
    }
}

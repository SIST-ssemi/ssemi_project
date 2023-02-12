package ssemi.ssemibucks.PRODUCT;

import java.util.Scanner;

public class ProductService {
    private final ProductDao productDao;
    Scanner sc = new Scanner(System.in);

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    // 전체 상품 조회
    public void allProduct() {
        System.out.println("전체 상품 조회\n");
        productDao.selectAllProduct();
    }

    // 상품 상세페이지
    public void detailProduct() {
        System.out.println("상품 상세 조회\n");

        // 상품 아이디 입력받고 해당 아이디 정보만 조회
        System.out.print("조회할 상품 아이디 입력 : ");
        String pId = sc.nextLine();
        System.out.println();

        // 상품 아이디 존재 여부 확인
        if (productDao.findBypId(pId) == null) {
            System.out.println("해당 상품 정보 없음\n\n");
            return;
        }
        productDao.selectProduct(pId);
    }

    // 상품 등록
    public void registerProduct() {
        System.out.println("상품 등록\n");

        while (true) {
            String pId;

            // 상품 정보 입력받고 저장
            System.out.print("추가할 상품 아이디 입력(p + 숫자 4자리) : ");
            pId = sc.nextLine();

            // 상품 아이디 p + 숫자 4자리 체크
            if (!pIdCheck(pId)) {
                System.out.println("상품 아이디는 p + 숫자 4자리로 생성 가능합니다.\n");
                break;
            }

            // 상품 아이디 중복 체크
            Product product = productDao.findBypId(pId);

            if (product != null) {
                System.out.println("입력한 상품 아이디와 동일한 상품이 존재합니다.\n");
                break;
            } else {
                System.out.print("추가할 상품명 입력 : ");
                String pName = sc.nextLine();

                System.out.print("추가할 상품 옵션 입력 : ");
                String pOption = sc.nextLine();

                System.out.print("추가할 상품 카테고리 입력 : ");
                String category = sc.nextLine();

                System.out.print("추가할 상품 가격 입력 : ");
                int price = Integer.parseInt(sc.nextLine());

                System.out.print("추가할 상품 재고 입력 : ");
                int pStock = Integer.parseInt(sc.nextLine());

                System.out.print("추가할 상품 상세 설명 입력 : ");
                String pDetail = sc.nextLine();

                System.out.print("추가할 상품 이미지 정보 입력 : ");
                String pImage = sc.nextLine();

                product = new Product(pId, pName, pOption, category, price, pStock, pDetail, pImage);
                productDao.insertProduct(product);
                break;
            }
        }

    }

    // 상품 삭제
    public void removeProduct() {
        System.out.println("상품 삭제\n");

        // 상품 아이디 입력받아서 조회 -> "삭제하시겠습니까?" -> 삭제
        System.out.print("삭제할 상품 아이디 입력 : ");
        String pId = sc.nextLine();
        System.out.println();

        // 상품 아이디 존재 여부 확인
        Product product = productDao.findBypId(pId);
        if (product == null) {
            System.out.println("해당 상품 정보 없음\n\n");
            return;
        }

        String pName = product.getpName();

        System.out.println("[" + pName + "] 삭제하시겠습니까?  1:yes  2:no");
        System.out.print("번호 입력 : ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println();
        if (num == 1) {
            productDao.deleteProduct(pId, pName);
        } else if (num == 2) {
            System.out.println("삭제 취소\n\n");
            return;
        } else {
            System.out.println("해당 번호 없음\n\n");
            return;
        }

    }

    // 상품 수정
    public void modifyProduct() {
        System.out.println("상품 수정\n");

        int num1, num2, input;
        String sql;

        // 상품 아이디 입력받아서 조회 -> "수정하시겠습니까?" -> 수정(수량, 가격만?)
        System.out.print("수정할 상품 아이디 입력 : ");
        String pId = sc.nextLine();
        System.out.println();

        Product product = productDao.findBypId(pId);

        // 상품 아이디 존재 여부 확인
        if (product == null) {
            System.out.println("해당 상품 정보 없음\n\n");
            return;
        }

        String pName = product.getpName();

        System.out.println("[" + pName + "] 수정하시겠습니까?  1:yes  2:no");
        System.out.print("번호 입력 : ");
        num1 = Integer.parseInt(sc.nextLine());
        System.out.println();

        if (num1 == 1) {
            System.out.println("[" + pName + "] 수정 - 1:가격  2:수량");
            System.out.print("번호 입력 : ");
            num2 = Integer.parseInt(sc.nextLine());
            System.out.println();

            if (num2 == 1) {
                sql = "update PRODUCT set price = ? where pId = ?";

                System.out.print("[" + pName + "] 수정할 가격 입력 : ");
                input = Integer.parseInt(sc.nextLine());
                System.out.println();
            } else if (num2 == 2) {
                sql = "update PRODUCT set pStock = ? where pId = ?";

                System.out.print("[" + pName + "] 수정할 수량 입력 : ");
                input = Integer.parseInt(sc.nextLine());
                System.out.println();
            } else {
                System.out.println("해당 번호 없음\n\n");
                return;
            }
        } else if (num1 == 2) {
            System.out.println("[" + pName + "] 수정 취소\n\n");
            return;
        } else {
            System.out.println("해당 번호 없음\n\n");
            return;
        }

        productDao.updateProduct(pId, pName, sql, input);
    }

    // 상품 아이디 무조건 p + 숫자 4자리
    private boolean pIdCheck(String pId) {
        return pId.matches("^p[0-9]{4}");
    }
}

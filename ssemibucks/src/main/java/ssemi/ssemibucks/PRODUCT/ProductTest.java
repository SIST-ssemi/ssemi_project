package ssemi.ssemibucks.PRODUCT;

import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        ProductService service = new ProductService(productDao);

        Scanner sc = new Scanner(System.in);
        int num;

        while (true) {
            System.out.println("1.insert  2.selectAll  3.detail  4.delete  5.update  0.exit");
            System.out.print("번호 입력 : ");
            num = Integer.parseInt(sc.nextLine());
            System.out.println();

            if (num == 1)
                service.registerProduct();
            else if (num == 2)
                service.allProduct();
            else if (num == 3)
                service.detailProduct();
            else if (num == 4)
                service.removeProduct();
            else if (num == 5)
                service.modifyProduct();
            else if (num == 0) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("번호 다시 입력\n");
            }
        }
    }
}

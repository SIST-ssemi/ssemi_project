package ssemi.ssemibucks.CART;

import ssemi.ssemibucks.PRODUCT.ProductDao;

import java.util.Scanner;

//public class CartTest {
//    public static void main(String[] args) {
//        CartDao cartDao = new CartDao();
//        ProductDao productDao = new ProductDao();
//        CartService service = new CartService(cartDao, productDao);
//
//        Scanner sc = new Scanner(System.in);
//        int num;
//
//        while (true) {
//            System.out.println("1.insert  2.selectAll  3.delete  4.update  0.exit");
//            System.out.print("번호 입력 : ");
//            num = Integer.parseInt(sc.nextLine());
//            System.out.println();
//
//            if (num == 1)
//                service.registerCart();
//            else if (num == 2)
//                service.allCart();
//            else if (num == 3)
//                service.removeCart();
//            else if (num == 4)
//                service.modifyCart();
//            else if (num == 0) {
//                System.out.println("프로그램 종료");
//                break;
//            } else {
//                System.out.println("번호 다시 입력\n");
//            }
//        }
//    }
//}
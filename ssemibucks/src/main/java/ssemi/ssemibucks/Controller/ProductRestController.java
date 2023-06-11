package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ssemi.ssemibucks.PRODUCT.Product;
import ssemi.ssemibucks.PRODUCT.ProductService;

import java.util.List;

@RestController
@CrossOrigin
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/getplist")
    public List<Product> productList() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/detail")
    public Product productDetail(@RequestParam String pId) {
        return productService.getProductByPId(pId);
    }

    @PostMapping("/product/insert")
    public void productInsert(@RequestBody Product product) {
        productService.insertOfProduct(product);
    }

    @PostMapping("/product/update")
    public void productUpdate(@RequestBody Product product) {
        productService.updateOfProduct(product);
    }

    @GetMapping("/product/delete")
    public void productDelete(@RequestParam String pId) {
        System.out.println(pId);
        productService.deleteOfProduct(pId);
    }

    @PostMapping("/product/pIdCheck")
    public Product pIdCheck(@RequestParam String pId) {
        return productService.isDuplicationPId(pId);
    }

}

package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}

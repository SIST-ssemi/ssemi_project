package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssemi.ssemibucks.PRODUCT.Product;
import ssemi.ssemibucks.PRODUCT.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/product_list")
    public String productList(Model model) {
        List<Product> products = productService.allProduct();
        model.addAttribute("products", products);
        return "/product/product_list";
    }

    @GetMapping ("/product/product_detail")
    public String productDetail(@RequestParam String pId, Model model) {
        Product product = productService.selectProduct(pId);
        model.addAttribute("product", product);

        return "/product/product_detail";
    }
}

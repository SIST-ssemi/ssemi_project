package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssemi.ssemibucks.PRODUCT.Product;
import ssemi.ssemibucks.PRODUCT.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/product_list")
    public String productList(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "/product/product_list";
    }

    @GetMapping("/admin/admin_pManagement")
    public String admin_pManagement(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "/admin/admin_pManagement";
    }

    @GetMapping("product/product_categoryList")
    public String productList_desserts(@RequestParam String category, Model model) {
        List<Product> products = productService.getAllProductsOfCategory(category);
        model.addAttribute("products", products);

        return "/product/product_categoryList";
    }

    @RequestMapping(value="/product/product_detail", method = RequestMethod.GET)
    public String productDetail(@RequestParam String pId, Model model) {
        Product product = productService.getProductByPId(pId);
        model.addAttribute("product", product);

        return "/product/product_detail";
    }

    @GetMapping ("/product/product_insert")
    public String productInsertForm() {
        return "/product/product_insert";
    }
    
    @PostMapping ("/product/product_insertAction")
    public String productInsert(Product product, Model model) {

        productService.insertOfProduct(product);

        model.addAttribute("msg",  "\\'" + product.getPName() + "\\'을/를 추가하였습니다");
        model.addAttribute("url", "/admin/admin_pManagement");

        return "/alert";
    }

    @GetMapping ("/product/product_update")
    public String productUpdate(@RequestParam String pId, Model model) {
        Product product = productService.getProductByPId(pId);
        model.addAttribute("product", product);

        return "/product/product_update";
    }
    
    @RequestMapping(value="/product/produt_updateAction", method = RequestMethod.POST)
    public String productUpdate(@RequestParam String pId, @RequestParam int price, @RequestParam int pStock, @RequestParam String pDetail, @RequestParam String pImage, Model model) {
        Product product = productService.getProductByPId(pId);

        product.setPrice(price);
        product.setPStock(pStock);
        product.setPDetail(pDetail);
        product.setPImage(pImage);

        productService.updateOfProduct(product);
        
        model.addAttribute("msg", "\\'" + product.getPName() + "\\'을/를 수정하였습니다");
        model.addAttribute("url", "/admin/admin_pManagement");

        return "/alert";
    }

    @GetMapping ("/product/product_delete")
    public String productDelete(@RequestParam String pId, Model model) {
        Product product = productService.getProductByPId(pId);
        productService.deleteOfProduct(pId);

        model.addAttribute("msg", "\\'" + product.getPName() + "\\'을/를 삭제하였습니다");
        model.addAttribute("url", "/admin/admin_pManagement");

        return "/alert";
    }

    @GetMapping("/product/product_chkId")
    public String chkId() {
        return "/product/product_chkId";
    }

    @RequestMapping(value = "/product/product_chkIdAction", method = RequestMethod.POST)
    public String chkIdAction(String chkId, Model model) {

        String result = productService.idDuplicationCheck(chkId);

        if (result.equals("중복아이디")) {
            model.addAttribute("msg", "중복된 아이디입니다. 다시 입력해주세요.");
            return "alert_idcheck";
        } else if(result.equals("조건확인")) {
            model.addAttribute("msg", "상품 아이디는 p + 숫자 4자리로 입력 가능합니다.");
            return "alert_idcheck";
        } else {
            model.addAttribute("msg", "사용가능한 아이디입니다.");
            return "alert_idcheck";
        }

    }
}

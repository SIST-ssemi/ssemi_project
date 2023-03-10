package ssemi.ssemibucks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssemi.ssemibucks.PRODUCT.Product;
import ssemi.ssemibucks.PRODUCT.ProductDao;
import ssemi.ssemibucks.PRODUCT.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @GetMapping("/admin/admin_pManagement")
    public String admin_pManagement(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Product> products = productService.allProduct();
        model.addAttribute("products", products);
        session.setAttribute("uId", "admin");

        return "/admin/admin_pManagement";
    }

    @GetMapping("product/product_categoryList")
    public String productList_desserts(@RequestParam String category, Model model) {
        List<Product> products = productService.selectCategoryProduct(category);
        model.addAttribute("products", products);

        return "/product/product_categoryList";
    }

    @RequestMapping(value="/product/product_detail", method = RequestMethod.GET)
    public String productDetail(@RequestParam String pId, Model model) {
        Product product = productService.selectProduct(pId);
        model.addAttribute("product", product);

        return "/product/product_detail";
    }

    @GetMapping ("/product/product_insert")
    public String productInsertForm() {
        return "/product/product_insert";
    }
    
    @PostMapping ("/product/product_insertAction")
    public String productInsert(ProductForm form, Model model) {
        Product product = new Product();
        product.setpId(form.getpId());
        product.setpName(form.getpName());
        product.setpOption(form.getpOption());
        product.setCategory(form.getCategory());
        product.setPrice(form.getPrice());
        product.setpStock(form.getpStock());
        product.setpDetail(form.getpDetail());
        product.setpImage(form.getpImage());

        productService.registerProduct(product);

        model.addAttribute("msg",  "\\'" + product.getpName() + "\\'???/??? ?????????????????????");
        model.addAttribute("url", "/admin/admin_pManagement");

        return "/alert";
    }

    @GetMapping ("/product/product_update")
    public String productUpdate(@RequestParam String pId, Model model) {
        Product product = productService.selectProduct(pId);
        model.addAttribute("product", product);

        return "/product/product_update";
    }
    @RequestMapping(value="/product/produt_updateAction", method = RequestMethod.POST)
    public String productUpdate(@RequestParam String pId, ProductForm form, Model model) {
        Product product = productService.selectProduct(pId);

        product.setPrice(form.getPrice());
        product.setpStock(form.getpStock());
        product.setpDetail(form.getpDetail());
        product.setpImage(form.getpImage());

        productService.modifyProduct(product);
        
        model.addAttribute("msg", "\\'" + product.getpName() + "\\'???/??? ?????????????????????");
        model.addAttribute("url", "/admin/admin_pManagement");

        return "/alert";
    }

    @GetMapping ("/product/product_delete")
    public String productDelete(@RequestParam String pId, Model model) {
        Product product = productService.selectProduct(pId);
        productService.removeProduct(product);

        model.addAttribute("msg", "\\'" + product.getpName() + "\\'???/??? ?????????????????????");
        model.addAttribute("url", "/admin/admin_pManagement");

        return "/alert";
    }

    @GetMapping("/product/product_chkId")
    public String chkId() {
        return "/product/product_chkId";
    }

    @RequestMapping(value = "/product/product_chkIdAction", method = RequestMethod.POST)
    public String chkIdAction(String chkId, Model model) {

        ProductDao dao = new ProductDao();
        String result = dao.idDuplication(chkId);

        if (result.equals("???????????????")) {
            model.addAttribute("msg", "????????? ??????????????????. ?????? ??????????????????.");
            return "alert_idcheck";
        } else if(result.equals("????????????")) {
            model.addAttribute("msg", "?????? ???????????? p + ?????? 4????????? ?????? ???????????????.");
            return "alert_idcheck";
        } else {
            model.addAttribute("msg", "??????????????? ??????????????????.");
            return "alert_idcheck";
        }

    }
}

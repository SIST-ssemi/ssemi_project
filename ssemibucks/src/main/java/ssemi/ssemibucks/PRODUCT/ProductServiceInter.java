package ssemi.ssemibucks.PRODUCT;

import java.util.List;

public interface ProductServiceInter {

    public List<Product> getAllProducts();
    public List<Product> getAllProductsOfCategory(String category);
    public Product getProductByPId(String pId);
    public void insertOfProduct(Product product);
    public void deleteOfProduct(String pId);
    public void updateOfProduct(Product product);
    public Product isDuplicationPId(String pId);
    public String idDuplicationCheck(String pId);
    public boolean pIdCheck(String pId);

}

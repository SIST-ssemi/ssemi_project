package ssemi.ssemibucks.PRODUCT;

import java.util.Vector;

public interface ProductServiceInter {

    public Vector<Product> selectAllProduct();
    public Vector<Product> selectCategoryProduct(String category);
    public Product selectProduct(String pId);
    public void insertProduct(Product product);
    public void deleteProduct(String pId);
    public void updateProduct(Product product);
    public Product findBypId(String pId);
    public String idDuplication(String pId);
    public boolean pIdCheck(String pId);

}

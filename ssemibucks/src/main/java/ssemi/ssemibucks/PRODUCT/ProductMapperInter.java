package ssemi.ssemibucks.PRODUCT;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Vector;

@Mapper
public interface ProductMapperInter {

    public List<Product> getAllProducts();
    public List<Product> getAllProductsOfCategory(String category);
    public Product getProductByPId(String pId);
    public void insertOfProduct(Product product);
    public void deleteOfProduct(String pId);
    public void updateOfProduct(Product product);
    public Product isDuplicationPId(String pId);

}

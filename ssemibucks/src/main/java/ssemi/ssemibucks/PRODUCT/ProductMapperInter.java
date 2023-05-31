package ssemi.ssemibucks.PRODUCT;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Vector;

@Mapper
public interface ProductMapperInter {

    public List<Product> selectAllProduct();
    public List<Product> selectCategoryProduct(String category);
    public Product selectProduct(String pId);
    public void insertProduct(Product product);
    public void deleteProduct(String pId);
    public void updateProduct(Product product);
    public Product findBypId(String pId);
    public String idDuplication(String pId);
    public boolean pIdCheck(String pId);

}

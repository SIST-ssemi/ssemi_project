package ssemi.ssemibucks.PRODUCT;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Product")
public class Product {
    private String pId;
    private String pName;
    private String pOption;
    private String category;
    private int price;
    private int pStock;
    private String pDetail;
    private String pImage;
}

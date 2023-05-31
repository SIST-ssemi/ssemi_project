package ssemi.ssemibucks.PRODUCT;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Product")
public class Product {
    public String pId;
    public String pName;
    public String pOption;
    public String category;
    public int price;
    public int pStock;
    public String pDetail;
    public String pImage;
}

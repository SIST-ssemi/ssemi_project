package ssemi.ssemibucks.CART;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Cart")
public class Cart {

    public String cId;
    public String uId;
    public String pId;
    public String pName;
    public String pOption;
    public String category;
    public int price;
    public int cQTY;
    public String pImage;

}

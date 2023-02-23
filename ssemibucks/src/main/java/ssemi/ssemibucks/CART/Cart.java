package ssemi.ssemibucks.CART;

public class Cart {
    private String cId;
    private String uId;
    private String pId;
    private String pName;
    private String pOption;
    private String category;
    private int price;
    private int cQty;
    private String pImage;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpOption() {
        return pOption;
    }

    public void setpOption(String pOption) {
        this.pOption = pOption;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getcQty() {
        return cQty;
    }

    public void setcQty(int cQty) {
        this.cQty = cQty;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }
}

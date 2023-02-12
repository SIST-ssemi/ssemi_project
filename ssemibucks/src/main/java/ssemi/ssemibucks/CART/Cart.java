package ssemi.ssemibucks.CART;

public class Cart {
    private String pId;
    private String pName;
    private String pOption;
    private int price;
    private int cQTY;

    public Cart(String pId, String pName, String pOption, int price, int cQTY) {
        this.pId = pId;
        this.pName = pName;
        this.pOption = pOption;
        this.price = price;
        this.cQTY = cQTY;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getcQTY() {
        return cQTY;
    }

    public void setcQTY(int cQTY) {
        this.cQTY = cQTY;
    }
}

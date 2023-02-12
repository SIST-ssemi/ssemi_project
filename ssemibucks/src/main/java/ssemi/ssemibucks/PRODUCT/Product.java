package ssemi.ssemibucks.PRODUCT;

public class Product {
    private String pId;
    private String pName;
    private String pOption;
    private String category;
    private int price;
    private int pStock;
    private String pDetail;
    private String pImage;

    public Product(String pId, String pName, String pOption, String category, int price, int pStock, String pDetail, String pImage) {
        this.pId = pId;
        this.pName = pName;
        this.pOption = pOption;
        this.category = category;
        this.price = price;
        this.pStock = pStock;
        this.pDetail = pDetail;
        this.pImage = pImage;
    }

    public Product(String pId, String pName, String pOption, int price) {
        this.pId = pId;
        this.pName = pName;
        this.pOption = pOption;
        this.price = price;
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

    public int getpStock() {
        return pStock;
    }

    public void setpStock(int pSTock) {
        this.pStock = pStock;
    }

    public String getpDetail() {
        return pDetail;
    }

    public void setpDetail(String pDetail) {
        this.pDetail = pDetail;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }
}

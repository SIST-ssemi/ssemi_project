package ssemi.ssemibucks.USER;

public class User {
    private String uId;
    private String uName;
    private String pw;
    private String hp;
    private String addr;

    public User(String uId, String uName, String pw, String hp, String addr) {
        this.uId = uId;
        this.uName = uName;
        this.pw = pw;
        this.hp = hp;
        this.addr = addr;
    }

    //로그인 용
    User(String uId, String pw) {
        this.uId = uId;
        this.pw = pw;
    }

    public User() {

    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

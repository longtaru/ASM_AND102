package mob.longnd.asm.model;

public class Product {
    int masp;
    String tensp;
    int giabam;
    int soluong;

    public Product(int masp, String tensp, int giabam, int soluong) {
        this.masp = masp;
        this.tensp = tensp;
        this.giabam = giabam;
        this.soluong = soluong;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGiabam() {
        return giabam;
    }

    public void setGiabam(int giabam) {
        this.giabam = giabam;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}

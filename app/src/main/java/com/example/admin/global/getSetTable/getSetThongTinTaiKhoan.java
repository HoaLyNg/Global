package com.example.admin.global.getSetTable;

/**
 * Created by User on 26/04/2017.
 */

public class getSetThongTinTaiKhoan {
    private int matk;
    private String ho;
    private String ten;
    private String ngaysinh;
    private int sdt;
    private String diachi;
    private String email;
    private String ghichu;
    private int loaitk;
    private String tendangnhap;
    private String matkhau;



    public getSetThongTinTaiKhoan(String ho, String ten, String ngaysinh, int sdt, String diachi,
                                  String email, String ghichu, int loaitk, String tendangnhap, String matkhau){

        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.email = email;
        this.ghichu = ghichu;
        this.loaitk = loaitk;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
    }
    public void setLoaitk(int loaitk) {
        this.loaitk = loaitk;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }



    public int getLoaitk() {
        return loaitk;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public int getMatk() {
        return matk;
    }

    public String getGhichu() {
        return ghichu;
    }

    public String getEmail() {
        return email;
    }

    public String getDiachi() {
        return diachi;
    }

    public int getSdt() {
        return sdt;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getTen() {
        return ten;
    }

    public String getHo() {
        return ho;
    }

    public void setMatk(int matk) {
        this.matk = matk;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }


}

package com.example.admin.global.DTO;

/**
 * Created by manti on 26/04/2017.
 */

public class Villa {
    private int maCT;
    private String diachi;
    private  String gia;
    private String ghichu;
    private int maTK;
    private double x;
    private double y;

    public int getMaCT() {
        return maCT;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getMaTK() {
        return maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Villa(int maCT, String diachi, String gia, String ghichu, int maTK, double x, double y) {
        this.maCT = maCT;
        this.diachi = diachi;
        this.gia = gia;
        this.ghichu = ghichu;
        this.maTK = maTK;
        this.x = x;
        this.y = y;
    }

    public Villa(String diachi, String gia, String ghichu, int maTK, double x, double y) {
        this.diachi = diachi;
        this.gia = gia;
        this.ghichu = ghichu;
        this.maTK = maTK;
        this.x = x;
        this.y = y;
    }
}

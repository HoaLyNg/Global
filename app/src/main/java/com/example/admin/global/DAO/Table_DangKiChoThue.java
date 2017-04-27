package com.example.admin.global.DAO;

import static com.example.admin.global.DAO.Table_ThongTinTaiKhoan.TABLE_THONGTINTAIKHOAN;

/**
 * Created by User on 26/04/2017.
 */

public class Table_DangKiChoThue  {
    public static final String TABLE_DANGKICHOTHUE = "DangKiChoThue";

    public static String getTableDangkichothue() {
        return TABLE_DANGKICHOTHUE;
    }





    //Cac trường của Bảng TABLE DANG KI CHO THUE
    private static final String DANGKICHOTHUE_MaCT = "MaCT";
    private static final String DANGKICHOTHUE_DIACHI = "DiaChi";
    private static final String DANGKICHOTHUE_GIA = "Gia";
    private static final String DANGKICHOTHUE_GHICHU = "GhiChu";
    private static final String DANGKICHOTHUE_THONGTINTAIKHOAN_MATK = "MaTK";





    //CREATE TABLE DANG KI CHO THUE
    public static final String CREATE_TABLE_DANGKICHOTHUE ="CREATE TABLE "+TABLE_DANGKICHOTHUE+" ("+DANGKICHOTHUE_MaCT+
            " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ""+DANGKICHOTHUE_DIACHI+" TEXT, "+DANGKICHOTHUE_GIA+" TEXT, "
            +DANGKICHOTHUE_GHICHU+" TEXT, "+DANGKICHOTHUE_THONGTINTAIKHOAN_MATK+" INTEGER CONSTRAINT " +
            "FK_ThongTinTaiKhoan REFERENCES "+TABLE_THONGTINTAIKHOAN+" ON UPDATE CASCADE)";
}

package com.example.admin.global.DAO;

import static com.example.admin.global.DAO.Table_DangKiChoThue.TABLE_DANGKICHOTHUE;

/**
 * Created by User on 26/04/2017.
 */

public class Table_Hinh {
    private static final String TABLE_HINH= "Hinh";
    public static String getTableHinh() {
        return TABLE_HINH;
    }
    //Cac trường của Bảng TABLE HINH
    private static final String HINH_MAHINH = "MaHinh";
    private static final String HINH_TENHINH = "TenHinh";
    private static final String HINH_DANGKICHOTHUE_MACT = "MaCT";
    //CREATE TABLE HINH
    public static final String CREATE_TABLE_HINH ="CREATE TABLE "+TABLE_HINH+" ("+HINH_MAHINH+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +HINH_TENHINH+" TEXT,  "+HINH_DANGKICHOTHUE_MACT+
            " INTEGER CONSTRAINT FK_DangKiChoThue REFERENCES "+TABLE_DANGKICHOTHUE+
            " ON UPDATE CASCADE)";
}
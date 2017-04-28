package com.example.admin.global.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin.global.DTO.DuLieu;

import static com.example.admin.global.DAO.Table_ThongTinTaiKhoan.TABLE_THONGTINTAIKHOAN;

/**
 * Created by User on 26/04/2017.
 */


public class Table_DangKiChoThue {

    SQLiteDatabase myDB;

    public static final String TABLE_DANGKICHOTHUE = "DangKiChoThue";
    //Cac trường của Bảng TABLE DANG KI CHO THUE
    private static final String DANGKICHOTHUE_MaCT = "MaCT";
    private static final String DANGKICHOTHUE_DIACHI = "DiaChi";
    private static final String DANGKICHOTHUE_GIA = "Gia";
    private static final String DANGKICHOTHUE_GHICHU = "GhiChu";
    private static final String DANGKICHOTHUE_X = "X";
    private static final String DANGKICHOTHUE_Y = "Y";
    private static final String DANGKICHOTHUE_THONGTINTAIKHOAN_MATK = "MaTK";

    public static String getTableDangkichothue() {
        return TABLE_DANGKICHOTHUE;
    }

    //CREATE TABLE DANG KI CHO THUE
    public static final String CREATE_TABLE_DANGKICHOTHUE = "CREATE TABLE " + TABLE_DANGKICHOTHUE + " ("
            + DANGKICHOTHUE_MaCT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DANGKICHOTHUE_DIACHI + " TEXT, "
            + DANGKICHOTHUE_GIA + " REAL, "
            + DANGKICHOTHUE_GHICHU + " TEXT, "
            + DANGKICHOTHUE_X + " REAL, "
            + DANGKICHOTHUE_Y + " REAL, "
            + DANGKICHOTHUE_THONGTINTAIKHOAN_MATK + " INTEGER CONSTRAINT FK_ThongTinTaiKhoan REFERENCES "
            + TABLE_THONGTINTAIKHOAN + " ON UPDATE CASCADE)";

    public Table_DangKiChoThue(Context context) {
        DuLieu dulieu = new DuLieu(context);
        myDB = dulieu.getWritableDatabase();
    }
}



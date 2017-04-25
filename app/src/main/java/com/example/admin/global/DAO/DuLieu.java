package com.example.admin.global.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 25/04/2017.
 */

public class DuLieu extends SQLiteOpenHelper {

    //Data Base Thue nha tro
    private static final String DATABASE_NAME = "ThueNhaTro.db";
    private static final int DATABASE_VERSION = 1;



    //Các Table
    private static final String TABLE_THONGTINTAIKHOAN = "ThongTinTaiKhoan";
    private static final String TABLE_HINH= "Hinh";
    private static final String TABLE_DANGKICHOTHUE = "DangKiChoThue";

    public static String getTableDangkichothue() {
        return TABLE_DANGKICHOTHUE;
    }
    public static String getTableThongtintaikhoan() {
        return TABLE_THONGTINTAIKHOAN;
    }
    public static String getTableHinh() {
        return TABLE_HINH;
    }

    //Cac trường của Bảng TABLE THONG TIN TAI KHOAN
    private static final String THONGTINTAIKHOAN_MATK = "MaTK";
    private static final String THONGTINTAIKHOAN_HO = "Ho";
    private static final String THONGTINTAIKHOAN_TEN = "Ten";
    private static final String THONGTINTAIKHOAN_NGAYSINH = "NgaySinh";
    private static final String THONGTINTAIKHOAN_SDT = "SDT";
    private static final String THONGTINTAIKHOAN_DIACHI = "DiaChi";
    private static final String THONGTINTAIKHOAN_EMAIL = "Email";
    private static final String THONGTINTAIKHOAN_GHICHU = "GhiChu";
    private static final String THONGTINTAIKHOAN_LOAITAIKHOAN = "LoaiTK";
    private static final String THONGTINTAIKHOAN_TENDANGNHAP = "TenDangNhap";
    private static final String THONGTINTAIKHOAN_MATKHAU = "MatKhau";

    //Cac trường của Bảng TABLE DANG KI CHO THUE
    private static final String DANGKICHOTHUE_MaCT = "MaCT";
    private static final String DANGKICHOTHUE_DIACHI = "DiaChi";
    private static final String DANGKICHOTHUE_GIA = "Gia";
    private static final String DANGKICHOTHUE_GHICHU = "GhiChu";
    private static final String DANGKICHOTHUE_THONGTINTAIKHOAN_MATK = "MaTK";

    //Cac trường của Bảng TABLE HINH
    private static final String HINH_MAHINH = "MaHinh";
    private static final String HINH_TENHINH = "TenHinh";
    private static final String HINH_DANGKICHOTHUE_MACT = "MaCT";

    //CREATE TABLE THONG TIN TAI KHOAN
    private static final String CREATE_TABLE_THONGTINTAIKHOAN = "CREATE TABLE "+TABLE_THONGTINTAIKHOAN+" ("+THONGTINTAIKHOAN_MATK+"" +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ""+THONGTINTAIKHOAN_HO+" TEXT, "+THONGTINTAIKHOAN_TEN+" TEXT, "
            +THONGTINTAIKHOAN_NGAYSINH+" TEXT, "+THONGTINTAIKHOAN_SDT+" INTEGER, "
            +THONGTINTAIKHOAN_DIACHI+" TEXT," +
            " "+THONGTINTAIKHOAN_EMAIL+" TEXT, "+THONGTINTAIKHOAN_GHICHU+" TEXT, "
            +THONGTINTAIKHOAN_LOAITAIKHOAN+" INTEGER, "+THONGTINTAIKHOAN_TENDANGNHAP+" TEXT," +
            " "+THONGTINTAIKHOAN_MATKHAU+" TEXT)";
    //CREATE TABLE DANG KI CHO THUE
    private static final String CREATE_TABLE_DANGKICHOTHUE ="CREATE TABLE "+TABLE_DANGKICHOTHUE+" ("+DANGKICHOTHUE_MaCT+
            " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ""+DANGKICHOTHUE_DIACHI+" TEXT, "+DANGKICHOTHUE_GIA+" TEXT, "
            +DANGKICHOTHUE_GHICHU+" TEXT, "+DANGKICHOTHUE_THONGTINTAIKHOAN_MATK+" INTEGER CONSTRAINT " +
            "FK_ThongTinTaiKhoan REFERENCES "+TABLE_THONGTINTAIKHOAN+" ON UPDATE CASCADE)";

    //CREATE TABLE HINH
    private static final String CREATE_TABLE_HINH ="CREATE TABLE "+TABLE_HINH+" ("+HINH_MAHINH+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +HINH_TENHINH+" TEXT,  "+HINH_DANGKICHOTHUE_MACT+
            " INTEGER CONSTRAINT FK_DangKiChoThue REFERENCES "+TABLE_DANGKICHOTHUE+
            " ON UPDATE CASCADE)";

    public DuLieu(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_THONGTINTAIKHOAN);
        db.execSQL(CREATE_TABLE_DANGKICHOTHUE);
        db.execSQL(CREATE_TABLE_HINH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_THONGTINTAIKHOAN);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DANGKICHOTHUE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_HINH);
            onCreate(db);
        }
    }
}

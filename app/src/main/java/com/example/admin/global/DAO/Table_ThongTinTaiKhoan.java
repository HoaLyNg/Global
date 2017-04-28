package com.example.admin.global.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin.global.DTO.DuLieu;
import com.example.admin.global.DTO.Villa;
import com.example.admin.global.DTO.getSetThongTinTaiKhoan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 26/04/2017.
 */

public class Table_ThongTinTaiKhoan {
    SQLiteDatabase myDB;

    public static final String TABLE_THONGTINTAIKHOAN = "ThongTinTaiKhoan";


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

    public static String getTableThongtintaikhoan() {
        return TABLE_THONGTINTAIKHOAN;
    }

    public static String getThongtintaikhoanLoaitaikhoan() {
        return THONGTINTAIKHOAN_LOAITAIKHOAN;
    }

    //CREATE TABLE THONG TIN TAI KHOAN
    public static final String CREATE_TABLE_THONGTINTAIKHOAN = "CREATE TABLE " + TABLE_THONGTINTAIKHOAN + " ("
            + THONGTINTAIKHOAN_MATK + "" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + THONGTINTAIKHOAN_HO + " TEXT, "
            + THONGTINTAIKHOAN_TEN + " TEXT, "
            + THONGTINTAIKHOAN_NGAYSINH + " TEXT, "
            + THONGTINTAIKHOAN_SDT + " INTEGER, "
            + THONGTINTAIKHOAN_DIACHI + " TEXT,"
            + THONGTINTAIKHOAN_EMAIL + " TEXT, "
            + THONGTINTAIKHOAN_GHICHU + " TEXT, "
            + THONGTINTAIKHOAN_LOAITAIKHOAN + " INTEGER, "
            + THONGTINTAIKHOAN_TENDANGNHAP + " TEXT,"
            + THONGTINTAIKHOAN_MATKHAU + " TEXT)";

    public Table_ThongTinTaiKhoan(Context context) {
        DuLieu dulieu = new DuLieu(context);
        myDB = dulieu.getWritableDatabase();
    }

    public boolean them_ThongTinTaiKhoan(getSetThongTinTaiKhoan tttk) {
        ContentValues values = new ContentValues();
        values.putNull(THONGTINTAIKHOAN_MATK);
        values.put(THONGTINTAIKHOAN_HO, tttk.getHo());
        values.put(THONGTINTAIKHOAN_TEN, tttk.getTen());
        values.put(THONGTINTAIKHOAN_NGAYSINH, tttk.getNgaysinh());
        values.put(THONGTINTAIKHOAN_SDT, tttk.getSdt());
        values.put(THONGTINTAIKHOAN_DIACHI, tttk.getDiachi());
        values.put(THONGTINTAIKHOAN_EMAIL, tttk.getEmail());
        values.put(THONGTINTAIKHOAN_GHICHU, tttk.getGhichu());
        values.put(THONGTINTAIKHOAN_LOAITAIKHOAN, tttk.getLoaitk());
        values.put(THONGTINTAIKHOAN_TENDANGNHAP, tttk.getTendangnhap());
        values.put(THONGTINTAIKHOAN_MATKHAU, tttk.getMatkhau());
        long id = myDB.insert(TABLE_THONGTINTAIKHOAN, null, values);
        if (id == -1)
            return false;
        return true;
    }

    public boolean sua_ThongTinTaiKhoan(getSetThongTinTaiKhoan tttk) {
        ContentValues values = new ContentValues();

        values.put(THONGTINTAIKHOAN_DIACHI, tttk.getDiachi());
        values.put(THONGTINTAIKHOAN_EMAIL, tttk.getEmail());
        values.put(THONGTINTAIKHOAN_GHICHU, tttk.getGhichu());

        int rows = myDB.update("ThongTinTaiKhoan", values, THONGTINTAIKHOAN_MATK + " = ? ", new String[]{String.valueOf(tttk.getMatk())});
        if (rows > 0) return true;
        return false;
    }

    /* public ArrayList<getSetThongTinTaiKhoan> hienthiThongTinTaiKhoan(){
         ArrayList<getSetThongTinTaiKhoan> taikhoan = new ArrayList<getSetThongTinTaiKhoan>();
         Cursor cursor = myDB.rawQuery("SELECT * FROM "+TABLE_THONGTINTAIKHOAN, null);
         if(cursor.getCount() > 0){
             cursor.moveToFirst();
             while (!cursor.isAfterLast()){
                 int valueMaTK = cursor.getInt(0);
                 String valueHo = cursor.getString(1);
                 String valueTen = cursor.getString(2);
                 String valueNgaySinh = cursor.getString(3);
                 int valueSDT = cursor.getInt(4);
                 String valueDiaChi = cursor.getString(5);
                 String valueEmail = cursor.getString(6);
                 String valueGhiChu = cursor.getString(7);
                 int valueLoaiTK = cursor.getInt(8);
                 String valueTenDangNhap = cursor.getString(9);
                 String valueMatKhau = cursor.getString(10);
                 getSetThongTinTaiKhoan tk = new getSetThongTinTaiKhoan(valueHo, valueTen, valueNgaySinh,
                         valueSDT, valueDiaChi, valueEmail, valueGhiChu, valueLoaiTK, valueTenDangNhap, valueMatKhau );
                 tk.setMatk(valueMaTK);
                 taikhoan.add(tk);
                 cursor.moveToNext();
             }
         }
         return taikhoan;
     }*/
    public List<getSetThongTinTaiKhoan> hienthiThongTinTaiKhoan() {
        List<getSetThongTinTaiKhoan> templist = new ArrayList<getSetThongTinTaiKhoan>();
        String sql = "SELECT * FROM " + Table_DangKiChoThue.getTableDangkichothue();
        Cursor cur = myDB.rawQuery(sql, null);
        cur.moveToPosition(-1);
        while (cur.moveToNext()) {
            getSetThongTinTaiKhoan dept = new getSetThongTinTaiKhoan(
                    cur.getInt(cur.getColumnIndex(THONGTINTAIKHOAN_MATK)),
                    cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_HO)),
                    cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_TEN)),
                    cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_NGAYSINH)),
                    cur.getInt((cur.getColumnIndex(THONGTINTAIKHOAN_SDT))),
                    cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_DIACHI)),
                    cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_EMAIL)),
                    cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_GHICHU)),
                    cur.getInt((cur.getColumnIndex(THONGTINTAIKHOAN_LOAITAIKHOAN))),
                    cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_TENDANGNHAP)),
                    cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_MATKHAU))
            );
            templist.add(dept);
        }
        return templist;
    }

    public getSetThongTinTaiKhoan hienThi(int tk) {
        String sql = "SELECT * FROM " + TABLE_THONGTINTAIKHOAN + " WHERE MaTK = " + tk;
        Cursor cur = myDB.rawQuery(sql, null);
        cur.moveToPosition(-1);
        cur.moveToNext();
        getSetThongTinTaiKhoan dept = new getSetThongTinTaiKhoan(
                cur.getInt(cur.getColumnIndex(THONGTINTAIKHOAN_MATK)),
                cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_HO)),
                cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_TEN)),
                cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_NGAYSINH)),
                cur.getInt((cur.getColumnIndex(THONGTINTAIKHOAN_SDT))),
                cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_DIACHI)),
                cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_EMAIL)),
                cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_GHICHU)),
                cur.getInt((cur.getColumnIndex(THONGTINTAIKHOAN_LOAITAIKHOAN))),
                cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_TENDANGNHAP)),
                cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_MATKHAU))
        );
        return dept;
    }
    public int DangNhap(String TK, String MK)
    {
        String sql = "select *" +
                " from " + TABLE_THONGTINTAIKHOAN + " where TenDangNhap like '" + TK + "' ";
        Cursor cur = myDB.rawQuery(sql, null);
        int t = cur.getCount();
        if(cur.getCount() == 0) {
            return -1;
        }
        else
        {
            cur.moveToPosition(0);
            if(cur.getString(cur.getColumnIndex(THONGTINTAIKHOAN_MATKHAU)).equals(MK))
            {
                return cur.getInt(cur.getColumnIndex(THONGTINTAIKHOAN_MATK));
            }
            else {
                return -1;
            }
        }
    }
}

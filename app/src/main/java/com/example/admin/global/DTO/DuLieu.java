package com.example.admin.global.DTO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.global.DAO.Table_DangKiChoThue;
import com.example.admin.global.DAO.Table_Hinh;
import com.example.admin.global.DAO.Table_ThongTinTaiKhoan;

/**
 * Created by User on 25/04/2017.
 */

public class DuLieu extends SQLiteOpenHelper {

    //Data Base Thue nha tro
    private static final String DATABASE_NAME = "ThueNhaTro.db";
    private static final int DATABASE_VERSION = 1;




    public DuLieu(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table_ThongTinTaiKhoan.CREATE_TABLE_THONGTINTAIKHOAN);
        db.execSQL(Table_DangKiChoThue.CREATE_TABLE_DANGKICHOTHUE);
        db.execSQL(Table_Hinh.CREATE_TABLE_HINH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion){
            db.execSQL("DROP TABLE IF EXISTS " + Table_ThongTinTaiKhoan.CREATE_TABLE_THONGTINTAIKHOAN);
            db.execSQL("DROP TABLE IF EXISTS " + Table_DangKiChoThue.CREATE_TABLE_DANGKICHOTHUE);
            db.execSQL("DROP TABLE IF EXISTS " + Table_Hinh.CREATE_TABLE_HINH);
            onCreate(db);
        }
    }
}

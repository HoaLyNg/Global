package com.example.admin.global.DAO;

/**
 * Created by manti on 26/04/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin.global.DTO.Villa;
import com.example.admin.global.DTO.DuLieu;


import java.util.ArrayList;
import java.util.List;


public class VillaDAO {
    Context context;
    DuLieu myData;
    SQLiteDatabase db;

    public VillaDAO(Context context) {
        myData = new DuLieu(context);
    }

    public void Add(Villa dept){
        db = myData.getWritableDatabase();
//Bổ sung tracsaction
        ContentValues values = new ContentValues();
        values.putNull("MaCT");
        values.put("DiaChi", dept.getDiachi());
        values.put("Gia", dept.getGia());
        values.put("GhiChu", dept.getGhichu());
        values.put("MaTK", dept.getMaTK());
        values.put("X", dept.getX());
        values.put("Y", dept.getY());

        db.insert(Table_DangKiChoThue.getTableDangkichothue(),null,values);
    }
    public List<Villa> getVilla(){
        List<Villa> templist = new ArrayList<Villa>();
        db = myData.getReadableDatabase();

        String sql = "SELECT * FROM " + Table_DangKiChoThue.getTableDangkichothue();
        Cursor cur = db.rawQuery(sql, null);
        cur.moveToPosition(-1);
        while(cur.moveToNext()){
            Villa dept = new Villa(
                    cur.getInt(cur.getColumnIndex("MaCT")),
                    cur.getString(cur.getColumnIndex("DiaChi")),
                    cur.getString(cur.getColumnIndex("Gia")),
                    cur.getString(cur.getColumnIndex("GhiChu")),
                    cur.getInt(cur.getColumnIndex("MaTK")),
                    cur.getDouble(cur.getColumnIndex("X")),
                    cur.getDouble(cur.getColumnIndex("Y"))
            );
            templist.add(dept);
        }
        return templist;
    }
}


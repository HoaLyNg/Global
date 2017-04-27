package com.example.admin.global;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import com.example.admin.global.DAO.Table_ThongTinTaiKhoan;
import com.example.admin.global.DTO.getSetThongTinTaiKhoan;

import java.util.ArrayList;

public class ThongTinTaiKhoan extends AppCompatActivity {

    private ArrayList<getSetThongTinTaiKhoan> list;
    Table_ThongTinTaiKhoan tbThongTinTaiKhoan;
    EditText edtHo, edtTen, edtSDT, edtEmail, edtDiaChi, edtNgaySinh;
    MultiAutoCompleteTextView mulAuTxtGhiChu;
    Button btbXacNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_tai_khoan);
        findViewIDThongTinTaiKhoan();
        tbThongTinTaiKhoan = new Table_ThongTinTaiKhoan(getApplicationContext());

    }
    public void findViewIDThongTinTaiKhoan(){
        edtHo = (EditText)findViewById(R.id.edtHo);
        edtTen = (EditText)findViewById(R.id.edtTen);
        edtSDT = (EditText)findViewById(R.id.edtSDT);
        edtDiaChi = (EditText)findViewById(R.id.edtDiaChi);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtNgaySinh = (EditText)findViewById(R.id.edtNgaySinh);
        mulAuTxtGhiChu = (MultiAutoCompleteTextView)findViewById(R.id.mulAuTxtGhiChu);
        btbXacNhan = (Button)findViewById(R.id.btnXacNhan);
    }
    public void submitXacNhan(View view){
       /* String ho = edtHo.getText().toString();
        String ten = edtTen.getText().toString();
        String ngaysinh = edtNgaySinh.getText().toString();
        int sdt =  Integer.parseInt(edtSDT.getText().toString());
        String diachi = edtDiaChi.getText().toString();
        String email = edtEmail.getText().toString();
        String ghichu = mulAuTxtGhiChu.getText().toString();
        if(!TextUtils.isEmpty(ho)){
            getSetThongTinTaiKhoan tk = new getSetThongTinTaiKhoan(ho,ten, ngaysinh, sdt, diachi, email, ghichu );
            tbThongTinTaiKhoan.them_ThongTinTaiKhoan(tk);
        }
        else{
            Toast.makeText(this, "k the them",Toast.LENGTH_SHORT).show();
        }*/
        //hien thi
      /*  list = tbThongTinTaiKhoan.hienthiThongTinTaiKhoan();
        edtHo.setText(list.get(1).getHo());
        edtTen.setText(list.get(2).getHo());
        edtNgaySinh.setText(list.get(3).getHo());
        edtSDT.setText(list.get(4).getHo());
        edtDiaChi.setText(list.get(5).getHo());
        edtEmail.setText(list.get(6).getHo());
        mulAuTxtGhiChu.setText(list.get(7).getHo());*/
    }
    public void showThongTinTaiKhoan(){

    }
}

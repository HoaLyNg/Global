package com.example.admin.global;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.example.admin.global.DAO.Table_ThongTinTaiKhoan;
import com.example.admin.global.DTO.getSetThongTinTaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class ThongTinTaiKhoan extends AppCompatActivity {

    getSetThongTinTaiKhoan user;
    Table_ThongTinTaiKhoan tbThongTinTaiKhoan;
    EditText edtHo, edtTen, edtSDT, edtEmail, edtDiaChi, edtNgaySinh;
    MultiAutoCompleteTextView mulAuTxtGhiChu;
    Button btbXacNhan;
    int bien;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_tai_khoan);

        tbThongTinTaiKhoan = new Table_ThongTinTaiKhoan(getApplicationContext());
        findViewIDThongTinTaiKhoan();
        showThongTinTaiKhoan();
        btbXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitXacNhan();
            }
        });
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

    public void submitXacNhan(){


        String diachi = edtDiaChi.getText().toString();
        String email = edtEmail.getText().toString();
        String ghichu = mulAuTxtGhiChu.getText().toString();
        user = new getSetThongTinTaiKhoan(bien, "", "", "", 0, diachi, email, ghichu , 0, "", "" );
        boolean tk = tbThongTinTaiKhoan.sua_ThongTinTaiKhoan(user);
        if (tk)
            Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "Không sửa được", Toast.LENGTH_SHORT).show();
    }

    public void showThongTinTaiKhoan(){
        intent = getIntent();
        bien = intent.getIntExtra("key", 1);
        user = tbThongTinTaiKhoan.hienThi(bien);
        edtHo.setText(user.getHo().toString());
        edtTen.setText(user.getTen().toString());
        edtSDT.setText(String.valueOf(user.getSdt()).toString());
        edtNgaySinh.setText(user.getNgaysinh().toString());
        edtDiaChi.setText(user.getDiachi().toString());
        edtEmail.setText(user.getEmail().toString());
        mulAuTxtGhiChu.setText(user.getGhichu().toString());
    }
}

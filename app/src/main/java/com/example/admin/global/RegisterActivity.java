package com.example.admin.global;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.global.DAO.Table_ThongTinTaiKhoan;
import com.example.admin.global.DAO.VillaDAO;
import com.example.admin.global.DTO.getSetThongTinTaiKhoan;

public class RegisterActivity extends AppCompatActivity {

    EditText TK, MK, MK2, Ho, Ten, NS, DC, DT, Email;
    Button DangKy;
    CheckBox LoaiTK;
    TextView Info;
    getSetThongTinTaiKhoan TKMoi;
    Table_ThongTinTaiKhoan TTTK;
    ScrollView scrV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TTTK = new Table_ThongTinTaiKhoan(getApplicationContext());


        TK = (EditText) findViewById(R.id.txtTK);
        MK = (EditText) findViewById(R.id.txtMK);
        MK2 = (EditText) findViewById(R.id.txtMK2);
        Ho = (EditText) findViewById(R.id.txtHo);
        Ten = (EditText) findViewById(R.id.txtTen);
        NS = (EditText) findViewById(R.id.txtNgaySinh);
        DC = (EditText) findViewById(R.id.txtDiaChi);
        DT = (EditText) findViewById(R.id.txtDT);
        Email = (EditText) findViewById(R.id.txtEmail);
        DangKy = (Button) findViewById(R.id.btnDK);
        LoaiTK = (CheckBox) findViewById(R.id.cbxLoaiTK);
        Info = (TextView) findViewById(R.id.txtInfo2);
        scrV = (ScrollView)findViewById(R.id.scrV);

        DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tMK = MK.getText().toString();
                String tMK2 = MK2.getText().toString();
                if (!tMK.equals(tMK2)) {
                    Info.setTextColor(Color.RED);
                    scrV.fullScroll(View.FOCUS_UP);
                    MK.setText("");
                    MK2.setText("");
                }
                else {
                    String tTK = TK.getText().toString();
                    String tHo = Ho.getText().toString();
                    String tTen = Ten.getText().toString();
                    String tNS = NS.getText().toString();
                    String tDC = DC.getText().toString();
                    int tSDT = Integer.valueOf(DT.getText().toString());
                    String tEmail = Email.getText().toString();
                    int tLoaiTK;
                    if (LoaiTK.isChecked())
                        tLoaiTK = 1;
                    else tLoaiTK = 0;
                    TKMoi = new getSetThongTinTaiKhoan(tHo, tTen, tNS, tSDT, tDC,
                            tEmail, "", tLoaiTK, tTK, tMK);
                    boolean flag = TTTK.them_ThongTinTaiKhoan(TKMoi);
                    if (flag == true) {
                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


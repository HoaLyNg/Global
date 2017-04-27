package com.example.admin.global;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.global.DAO.Table_ThongTinTaiKhoan;
import com.example.admin.global.DAO.VillaDAO;
import com.example.admin.global.DTO.getSetThongTinTaiKhoan;

public class RegisterActivity extends AppCompatActivity {

    EditText DN, MK, MK2, Ho, Ten, NS, DC, DT, Email;
    Button DangKy;
    CheckBox LoaiTK;
    TextView Info;
    getSetThongTinTaiKhoan TKMoi;
    Table_ThongTinTaiKhoan TTTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        DN = (EditText) findViewById(R.id.txtTenDN);
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
        Info = (TextView) findViewById(R.id.txtInfo);
        DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tMK = MK.getText().toString();
                String tMK2 = MK2.getText().toString();
                if (MK != MK2)
                    Info.setTextColor(Color.RED);
                else {
                    String tDN = DN.getText().toString();
                    String tHo = Ho.getText().toString();
                    String tTen = Ten.getText().toString();
                    String tNS = NS.getText().toString();
                    String tDC = DC.getText().toString();
                    int tSDT = Integer.valueOf(DN.getText().toString());
                    String tEmail = Email.getText().toString();
                    int tLoaiTK;
                    if (LoaiTK.isChecked())
                        tLoaiTK = 1;
                    else tLoaiTK = 0;
                    TKMoi = new getSetThongTinTaiKhoan(tHo, tTen, tNS, tSDT, tDC,
                            tEmail, "", tLoaiTK, tDN, tMK);
                    boolean flag = TTTK.them_ThongTinTaiKhoan(TKMoi);
                    if (flag == true) {
                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        //Cần thêm intent qua form map
                    } else
                        Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}


 package com.example.admin.global;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.global.DAO.Table_ThongTinTaiKhoan;

 public class UserLogActivity extends AppCompatActivity {

    EditText TK, MK;
     TextView DK, QMK, Info;
     Button DN;
     Table_ThongTinTaiKhoan TTTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log);

        TTTK = new Table_ThongTinTaiKhoan(getApplicationContext());

        TK = (EditText)findViewById(R.id.txtTenDN);
        MK = (EditText)findViewById(R.id.txtMK);
        DK = (TextView)findViewById(R.id.btnDangKy);
        QMK = (TextView)findViewById(R.id.btnQMK);
        DN = (Button)findViewById(R.id.btnDN);
        Info = (TextView)findViewById(R.id.txtInfo);


        DN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tTK = TK.getText().toString();
                String tMK = MK.getText().toString();

                int ID = TTTK.DangNhap(tTK,tMK);
                if(ID == -1)
                {
                    Info.setTextColor(Color.RED);
                }
                else
                {
                    Toast.makeText(UserLogActivity.this, "Dăng nhập thành công", Toast.LENGTH_SHORT).show();

                }

            }
        });

        DK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        QMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserLogActivity.this, "Coming Sooooon...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

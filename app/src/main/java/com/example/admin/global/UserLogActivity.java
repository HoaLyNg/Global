 package com.example.admin.global;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 public class UserLogActivity extends AppCompatActivity {

    EditText TK, MK;
     TextView DK, QMK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log);

        TK = (EditText)findViewById(R.id.txtTenDN);
        MK = (EditText)findViewById(R.id.txtMK);
        DK = (TextView)findViewById(R.id.btnDangKy);
        QMK = (TextView)findViewById(R.id.btnQMK);

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

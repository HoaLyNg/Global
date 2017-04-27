package com.example.admin.global;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.example.admin.global.DAO.VillaDAO;
import com.example.admin.global.DTO.Villa;

public class DangKiChoThue extends AppCompatActivity {
    VillaDAO valaDAO;
    Button btnXacNhanCT;
    EditText edtGia, edtDiaChiCT;
    MultiAutoCompleteTextView mulAuTxtGhiChuCT;
    GridView grvHinh;

    Intent intent;
    int maTaiKhoan;
    double X,Y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki_cho_thue);
        findViewIDDangKiChoThue();
        valaDAO = new VillaDAO(getApplicationContext());
        intent = getIntent();
        maTaiKhoan = intent.getIntExtra("key", 1);
        X = Y = 10;
        btnXacNhanCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Villa vila = new Villa(edtDiaChiCT.getText().toString(),edtGia.getText().toString()
                              ,mulAuTxtGhiChuCT.getText().toString(), maTaiKhoan, X, Y);
                boolean id = valaDAO.Add(vila);
                if(id)
                    Toast.makeText(DangKiChoThue.this, "Đăng kí thành công !", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DangKiChoThue.this, "Thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }

   public void findViewIDDangKiChoThue(){
       edtDiaChiCT = (EditText)findViewById(R.id.edtDiaChiCT);
       edtGia = (EditText)findViewById(R.id.edtGia);
       btnXacNhanCT = (Button)findViewById(R.id.btnXacNhanCT);
       grvHinh = (GridView)findViewById(R.id.grvHinh);
       mulAuTxtGhiChuCT = (MultiAutoCompleteTextView)findViewById(R.id.mulAuTxtGhiChuCT);
   }
}

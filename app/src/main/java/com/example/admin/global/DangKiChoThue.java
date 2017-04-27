package com.example.admin.global;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.MultiAutoCompleteTextView;

import com.example.admin.global.DAO.VillaDAO;
import com.example.admin.global.DTO.Villa;

public class DangKiChoThue extends AppCompatActivity {
    VillaDAO valaDAO;
    Button btnXacNhanCT;
    EditText edtGia, edtDiaChiCT;
    MultiAutoCompleteTextView mulAuTxtGhiChuCT;
    GridView grvHinh;
    int maTaiKhoan;
    double X,Y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki_cho_thue);
        findViewIDDangKiChoThue();
        valaDAO = new VillaDAO(getApplicationContext());
        btnXacNhanCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Villa vila = new Villa(edtDiaChiCT.getText().toString(),edtGia.getText().toString()
                              ,mulAuTxtGhiChuCT.getText().toString(), maTaiKhoan,X, Y);
                valaDAO.Add(vila);

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

package com.example.admin.global;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.MultiAutoCompleteTextView;

public class DangKiChoThue extends AppCompatActivity {

    Button btnXacNhanCT;
    EditText edtGia, edtDiaChiCT;
    MultiAutoCompleteTextView mulAuTxtGhiChuCT;
    GridView grvHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki_cho_thue);
        findViewIDDangKiChoThue();
    }

   public void findViewIDDangKiChoThue(){
       edtDiaChiCT = (EditText)findViewById(R.id.edtDiaChiCT);
       edtGia = (EditText)findViewById(R.id.edtGia);
       btnXacNhanCT = (Button)findViewById(R.id.btnXacNhanCT);
       grvHinh = (GridView)findViewById(R.id.grvHinh);
       mulAuTxtGhiChuCT = (MultiAutoCompleteTextView)findViewById(R.id.mulAuTxtGhiChuCT);
   }
}

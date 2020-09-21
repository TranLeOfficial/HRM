package com.nhan.hrm.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nhan.hrm.R;

public class Add_Staff_Activity extends AppCompatActivity {
    Button btnAcc, btnXemDSNV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_staff_layout);
        Anhxa();
        setEvent();
    }
    private void setEvent() {
        //Xử lý Quản lý Dự Án
        btnAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add_Staff_Activity.this, Add_Manager_Activity.class);
                startActivity(intent);
            }
        });
        btnXemDSNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add_Staff_Activity.this, List_Staff.class);
                startActivity(intent);
            }
        });
    }


    public void Anhxa()
    {
        btnXemDSNV = findViewById(R.id.btnXemDSNV);
        btnAcc = findViewById(R.id.btnTaoAcc);
    }
}

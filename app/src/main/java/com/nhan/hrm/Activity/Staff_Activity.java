package com.nhan.hrm.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nhan.hrm.R;

public class Staff_Activity extends AppCompatActivity {
    Button btnLichLamViecNV, btnXemChamCongNV, btnXemDuAnNV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_layout);
        Anhxa();
        setControl();
    }

    private void setControl() {
        btnLichLamViecNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Staff_Activity.this, "NoListView", Toast.LENGTH_LONG).show();
            }
        });

        btnXemChamCongNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Staff_Activity.this, Date_Activity.class);
                startActivity(intent);
            }
        });

        btnXemDuAnNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Staff_Activity.this, "NoListView", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void Anhxa() {
        btnLichLamViecNV = findViewById(R.id.btnLichLamViecNV);
        btnXemChamCongNV = findViewById(R.id.btnXemChamCongNV);
        btnXemDuAnNV = findViewById(R.id.btnXemDuAnNV);
    }
}

package com.nhan.hrm.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nhan.hrm.R;

public class Manager_Activity extends AppCompatActivity {
    Button btnChamCongQL, btnLuongQL, btnThemNVQL, btnDuAnQL, btnTaiKhoanQL;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_layout);
        Anhxa();
        setEvent();

    }

    private void setEvent() {
        btnChamCongQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Manager_Activity.this, Date_Activity.class);
                startActivity(intent);
            }
        });

        //Xử lý Lương
        btnLuongQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Manager_Activity.this, Salary_Activity.class);
                startActivity(intent);
            }
        });

        //Xử lý Thêm Nhân Viên
        btnThemNVQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Manager_Activity.this, Add_Staff_Activity.class);
                startActivity(intent);
            }
        });

        //Xử lý Quản lý Tài Khoản
        btnDuAnQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Manager_Activity.this, Detail_Project_Activity.class);
                startActivity(intent);
            }
        });

        //Xử lý Quản lý Dự Án
        btnTaiKhoanQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Manager_Activity.this, Add_Manager_Activity.class);
                startActivity(intent);
            }
        });
    }


    public void Anhxa()
    {
        btnChamCongQL = findViewById(R.id.btnChamCongQL);
        btnLuongQL = findViewById(R.id.btnLuongQL);
        btnThemNVQL = findViewById(R.id.btnThemNVQL);
        btnDuAnQL = findViewById(R.id.btnDuAnQL);
        btnTaiKhoanQL = findViewById(R.id.btnTaiKhoanQL);
    }

}

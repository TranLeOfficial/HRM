package com.nhan.hrm.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nhan.hrm.R;

public class Detail_Project_Activity extends AppCompatActivity {
    Button btnSuaProject, btnLuuDuAn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_project_layout);
        Anhxa();
        setEvent();
    }

    private void setEvent() {
//        btnSuaProject.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Detail_Project_Activity.this, ProjectActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        btnLuuDuAn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ManageProjectActivity.this, ViewProjectActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private void Anhxa() {
    }
}

package com.nhan.hrm.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nhan.hrm.Adapter.Staff_Adapter;
import com.nhan.hrm.Model.StaffModel;
import com.nhan.hrm.R;

import java.util.ArrayList;

public class List_Staff extends AppCompatActivity {
    private ListView listViewDanhSachNV;
    private ArrayList<StaffModel> staffModelArrayList;
    private Staff_Adapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_staff);
        listViewDanhSachNV = findViewById(R.id.listViewDanhSachNV);
        staffModelArrayList = new ArrayList<>();
        GetData();
//        staffModelArrayList.add(new StaffModel("1", "123", "Nguyen Van A",
//                "tranthanhnhank111@gmail.com", "Nhan Vien", "Nam",
//                "Thu Duc", "012345678", "Chua Tham Gia"));
//        staffModelArrayList.add(new StaffModel("2", "234", "Nguyen Van B",
//                "tranthanhnhank123@gmail.com", "Nhan Vien", "Nam",
//                "Thu Duc", "012345678", "Chua Tham Gia"));
//        staffModelArrayList.add(new StaffModel("3", "345", "Nguyen Van C",
//                "tranthanhnhank100@gmail.com", "Nhan Vien", "Nam",
//                "Thu Duc", "012345678", "Chua Tham Gia"));
//        staffModelArrayList.add(new StaffModel("4", "456", "Tran Thi D",
//                "tranthanhnhank222@gmail.com", "Nhan Vien", "Nu",
//                "Thu Duc", "012345678", "Chua Tham Gia"));
//        staffModelArrayList.add(new StaffModel("5", "567", "Nguyen Van E",
//                "tranthanhnhank333@gmail.com", "Nhan Vien", "Nam",
//                "Thu Duc", "012345678", "Chua Tham Gia"));
        adapter = new Staff_Adapter(this, R.layout.custom_list_staff, staffModelArrayList);
        listViewDanhSachNV.setAdapter(adapter);
    }

    private void GetData()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("keri2020hrm/DBNhanVien");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adapter.clear(); //xoa het du lieu gia

                for(DataSnapshot data : snapshot.getChildren())
                {
                    StaffModel staffModel = new StaffModel();
                    staffModel.setID(data.getKey());
                    adapter.add(staffModel);
                    Log.d("MYTAG", "onDatachange" + staffModel.getHoTen());
                }
                Toast.makeText(getApplicationContext(), "LoadDataSuccess", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "LoadDataFailed"+ error.toString(), Toast.LENGTH_SHORT).show();
                Log.d("MYTAG", "onCanceled" + error.toString());
            }
        });
    }

}

package com.nhan.hrm.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nhan.hrm.Model.StaffModel;
import com.nhan.hrm.R;

import java.util.ArrayList;

public class Staff_Adapter extends ArrayAdapter<StaffModel> {
    Activity activity; int resource; ArrayList<StaffModel> objects;
    public Staff_Adapter(@NonNull Activity activity, int resource, @NonNull ArrayList<StaffModel> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =  this.activity.getLayoutInflater();
        View view = inflater.inflate(this.resource, null);

        TextView MaNV = view.findViewById(R.id.customStaff_MaNV);
        TextView TenNV = view.findViewById(R.id.customStaff_HoTen);
        TextView GmailNV = view.findViewById(R.id.customStaff_Email);


        StaffModel staffModel = this.objects.get(position);
        MaNV.setText(staffModel.getMSNV());
        TenNV.setText(staffModel.getHoTen());
        GmailNV.setText(staffModel.getGmail());
        return view;
    }
}

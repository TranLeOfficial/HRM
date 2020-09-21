package com.nhan.hrm.Activity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nhan.hrm.R;

import java.text.DateFormat;
import java.util.Calendar;

public class Date_Activity extends AppCompatActivity {

    TextView txtGioBatDau, txtGioKetThuc;
    RadioButton rdoNghiPhep, rdoKhongLyDo;
    RadioGroup rdoGroup;

    DateFormat fmtDateAndTime = DateFormat.getTimeInstance();
    Calendar myCalendarStart = Calendar.getInstance();
    Calendar myCalendarFinish = Calendar.getInstance();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nhanluong, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuThoat) {
            startActivity(new Intent(getApplicationContext(), Manager_Activity.class));
            Toast.makeText(this, "<-BACK", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    TimePickerDialog.OnTimeSetListener timeStart = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            myCalendarStart.set(Calendar.HOUR_OF_DAY, hourOfDay);
            myCalendarFinish.set(Calendar.MINUTE, minute);
            updateLabelStart();
        }
    };
    TimePickerDialog.OnTimeSetListener timeFinish = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            myCalendarStart.set(Calendar.HOUR_OF_DAY, hourOfDay);
            myCalendarFinish.set(Calendar.MINUTE, minute);
            updateLabelFinish();
        }
    };

    private void updateLabelStart() {
        txtGioBatDau.setText(fmtDateAndTime.format(myCalendarStart.getTime()));
    }

    private void updateLabelFinish() {
        txtGioKetThuc.setText(fmtDateAndTime.format(myCalendarFinish.getTime()));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_layout);

        txtGioBatDau = findViewById(R.id.txtGioBatDau);
        txtGioKetThuc = findViewById(R.id.txtGioKetThuc);
        rdoGroup = findViewById(R.id.rdoGroup);
        rdoNghiPhep = findViewById(R.id.rdoNghiPhep);
        rdoKhongLyDo = findViewById(R.id.rdoKhongLyDo);

        txtGioBatDau.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new TimePickerDialog(Date_Activity.this, timeStart,
                        myCalendarStart.get(Calendar.HOUR_OF_DAY),
                        myCalendarStart.get(Calendar.MINUTE), true).show();

            }
        });
        txtGioKetThuc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new TimePickerDialog(Date_Activity.this, timeFinish,
                        myCalendarStart.get(Calendar.HOUR_OF_DAY),
                        myCalendarStart.get(Calendar.MINUTE), true).show();
            }
        });

        rdoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                txtGioBatDau.setText("00:00:00");
                txtGioKetThuc.setText("00:00:00");
            }
        });

    }
}

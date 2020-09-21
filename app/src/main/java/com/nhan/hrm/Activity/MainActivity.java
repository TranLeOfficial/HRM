package com.nhan.hrm.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nhan.hrm.Adapter.MenuAdapter;
import com.nhan.hrm.R;
import com.nhan.hrm.Model.MenuModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listView;
    DrawerLayout drawerLayout;

    RadioButton rdoQuanLy, rdoNhanVien;
    RadioGroup rdoGroup;
    EditText edtMainEmail, edtMainPass;

    ////Các nút chức năng
    Button btnLogin, btnSignin;

    ArrayList<MenuModel> menuModelArrayList;
    MenuAdapter menuAdapter;
    FirebaseAuth fAuth;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        AnhXa();
        ActionViewFlipper();
        ActionBar();
        getIntent();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, Nhan!");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdoQuanLy.isChecked()) {
                    String email = edtMainEmail.getText().toString().trim();
                    String password = edtMainPass.getText().toString().trim();
                    if (TextUtils.isEmpty(email)) {
                        edtMainEmail.setError("Vui lòng nhập Email");
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        edtMainPass.setError("Vui lòng nhập mật khẩu");
                        return;
                    }
                    if (password.length() < 6) {
                        edtMainPass.setError("Mật khẩu phải từ 6 kí tự trở lên");
                    }
                    fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Manager_Activity.class));
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else if (rdoNhanVien.isChecked()) {
                    Toast.makeText(MainActivity.this, "Vui lòng liên hệ quản lý tạo tài khoản", Toast.LENGTH_SHORT).show();
//                    intent = new Intent(MainActivity.this, Staff_Activity.class);
//                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn quyền đăng nhập!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, Register_Activity.class);
                startActivity(intent);
            }
        });


    }


    public void AnhXa() {
        //anhxa cac chuc nang
        rdoGroup = findViewById(R.id.rdoGroup);
        rdoNhanVien = findViewById(R.id.rdoNhanvien);
        rdoQuanLy = findViewById(R.id.rdoQuanly);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignin = findViewById(R.id.btnSignin);

        edtMainEmail = findViewById(R.id.edtMainEmail);
        edtMainPass = findViewById(R.id.edtMainPass);

        toolbar = findViewById(R.id.toolBar);
        viewFlipper = findViewById(R.id.viewLipper);
        navigationView = findViewById(R.id.navigationview);
        listView = findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerLayout);
        fAuth = FirebaseAuth.getInstance();


        menuModelArrayList = new ArrayList<>();
        menuModelArrayList.add(0, new MenuModel("Đọc", "https://chauminhhay.files.wordpress.com/2016/07/gt.jpg"));
        menuModelArrayList.add(1, new MenuModel("Lịch Sử", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQei4emfqLSGIL5ieUaQGTTLL3eIC3Guu1WJg&usqp=CAU"));
        menuModelArrayList.add(2, new MenuModel("Đăng Ký", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRUge2K74gudsxXc9sT-PYmleavY1_jFF53-Q&usqp=CAU"));
        menuModelArrayList.add(3, new MenuModel("Thoát", "https://thuemaychuao.net/wp-content/uploads/2020/02/tao-icon-shutdown-hoac-restart-ngoai-desktop-1.jpg"));
        menuAdapter = new MenuAdapter(menuModelArrayList, getApplicationContext());
        listView.setAdapter(menuAdapter);
    }

    public void ActionViewFlipper() {
        ArrayList<String> mangQuangCao = new ArrayList<>();
        mangQuangCao.add("https://hris.emsc.vn/wp-content/uploads/2018/06/a-2.png");
        mangQuangCao.add("https://emsc.vn/wp-content/uploads/2018/03/tht.jpg");
        mangQuangCao.add("https://cmcsoft.com/image/data/nhan-su.jpg");
        mangQuangCao.add("https://l-a.com.vn/wp-content/uploads/2018/10/human-2.jpg");
        mangQuangCao.add("https://emsc.vn/wp-content/uploads/2020/04/nhan-su-ung-pho-dich-covid19.jpg");
        mangQuangCao.add("https://getflycrm.com/wp-content/uploads/2017/06/cong-ty-tu-te-nhan-su-gan-bo-lau-dai.jpg");

        for (int i = 0; i < mangQuangCao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangQuangCao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation animationSlideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animationSlideOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animationSlideIn);
        viewFlipper.setOutAnimation(animationSlideOut);
    }

    public void ActionBar() {
        //ham ho tro toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
}
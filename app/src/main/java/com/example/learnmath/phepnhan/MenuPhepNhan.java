package com.example.learnmath.phepnhan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnmath.R;

public class MenuPhepNhan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        LinearLayout bangnhan = findViewById(R.id.bangnhan_button);
        bangnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepNhan.this, BangNhan.class);
                startActivity(intent);
            }
        });

        LinearLayout nhan1x1chuso = findViewById(R.id.nhan1x1chuso_button);
        nhan1x1chuso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepNhan.this, NhanMotVoiMotChuSo.class);
                startActivity(intent);
            }
        });

        LinearLayout nhan2x1ChuSo = findViewById(R.id.nhan2x1chuso_button);
        nhan2x1ChuSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepNhan.this, NhanHaiVoiMotChuSo.class);
                startActivity(intent);
            }
        });

        LinearLayout nhan2x2ChuSo = findViewById(R.id.nhan2x2chuso_button);
        nhan2x2ChuSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepNhan.this, NhanHaiVoiHaiChuSo.class);
                startActivity(intent);
            }
        });

        LinearLayout nhan3x1ChuSo = findViewById(R.id.nhan3x1chuso_button);
        nhan3x1ChuSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepNhan.this, NhanBaVoiMotChuSo.class);
                startActivity(intent);
            }
        });

        LinearLayout PhepNhanDonGian = findViewById(R.id.phepnhandongian_button);
        PhepNhanDonGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepNhan.this, com.example.learnmath.phepnhan.PhepNhanDonGian.class);
                startActivity(intent);
            }
        });
    }

    private int getLayoutResourceId() {
        return R.layout.activity_phep_nhan;
    }
}
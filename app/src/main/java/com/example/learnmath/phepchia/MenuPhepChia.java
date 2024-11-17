package com.example.learnmath.phepchia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnmath.R;

public class MenuPhepChia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        LinearLayout BangChia = findViewById(R.id.bangchia_button);
        BangChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepChia.this, Bangchia.class);
                startActivity(intent);
            }
        });

        LinearLayout Chia1ChuSo = findViewById(R.id.chia1chuso_button);
        Chia1ChuSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepChia.this, Chia1_1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout Chia2ChuSo = findViewById(R.id.chia2chuso_button);
        Chia2ChuSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepChia.this, Chia2_1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout ChiaSoHaiDonVi = findViewById(R.id.chiasohaidonvi_button);
        ChiaSoHaiDonVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepChia.this, Chia2_2chuso.class);
                startActivity(intent);
            }
        });


        LinearLayout ChiaBaSo = findViewById(R.id.chiabachuso_button);
        ChiaBaSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepChia.this, Chia3_1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout PhepChiaDonGian = findViewById(R.id.phepchiadongian_button);
        PhepChiaDonGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepChia.this, com.example.learnmath.phepchia.PhepChiaDonGian.class);
                startActivity(intent);
            }
        });
    }

    private int getLayoutResourceId() {
        return R.layout.activity_division;
    }
}
package com.example.learnmath.phepcong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnmath.R;

public class MenuPhepCong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_phep_cong);

        LinearLayout continuousAdditionButton = findViewById(R.id.continuous_addition_button);
        continuousAdditionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
                Intent intent = new Intent(MenuPhepCong.this, PhepCongLienTiepActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout cong1chusoButton = findViewById(R.id.cong1chuso_button);
        cong1chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepCong.this, Cong1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout cong2chusoButton = findViewById(R.id.cong2chuso_button);
        cong2chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepCong.this, Cong2chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout cong3chusoButton = findViewById(R.id.cong3chuso_button);
        cong3chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepCong.this, Cong3chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout cong3soButton = findViewById(R.id.cong3so_button);
        cong3soButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPhepCong.this, Cong3so.class);
                startActivity(intent);
            }
        });

        LinearLayout congDonGian = findViewById(R.id.congdongian);
        congDonGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
                Intent intent = new Intent(MenuPhepCong.this, PhepCongDonGian.class);
                startActivity(intent);
            }
        });
    }
}
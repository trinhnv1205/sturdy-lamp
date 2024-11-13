package com.example.learnmath.multiplications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnmath.R;

public class MultiplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        LinearLayout bangnhan = findViewById(R.id.bangnhan_button);
        bangnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiplicationActivity.this, Bangnhan.class);
                startActivity(intent);
            }
        });

        LinearLayout nhan1x1chuso = findViewById(R.id.nhan1x1chuso_button);
        nhan1x1chuso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiplicationActivity.this, Nhan1x1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout nhan2x1ChuSo = findViewById(R.id.nhan2x1chuso_button);
        nhan2x1ChuSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiplicationActivity.this, Nhan2x1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout nhan2x2ChuSo = findViewById(R.id.nhan2x2chuso_button);
        nhan2x2ChuSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiplicationActivity.this, Nhan2x2chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout nhan3x1ChuSo = findViewById(R.id.nhan3x1chuso_button);
        nhan3x1ChuSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiplicationActivity.this, Nhan3x1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout PhepNhanDonGian = findViewById(R.id.phepnhandongian_button);
        PhepNhanDonGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiplicationActivity.this, Phepnhandongian.class);
                startActivity(intent);
            }
        });
    }

    private int getLayoutResourceId() {
        return R.layout.activity_multiplication;
    }
}
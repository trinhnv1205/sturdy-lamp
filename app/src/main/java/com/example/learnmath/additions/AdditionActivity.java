package com.example.learnmath.additions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnmath.R;

public class AdditionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        LinearLayout continuousButton = findViewById(R.id.continuous_addition_button);
        continuousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdditionActivity.this, ContinuousAdditionActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout cong1chusoButton = findViewById(R.id.cong1chuso_button);
        cong1chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdditionActivity.this, Cong1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout cong2chusoButton = findViewById(R.id.cong2chuso_button);
        cong2chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdditionActivity.this, Cong2chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout cong3chusoButton = findViewById(R.id.cong3chuso_button);
        cong3chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdditionActivity.this, Cong3chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout cong3soButton = findViewById(R.id.cong3so_button);
        cong3soButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdditionActivity.this, Cong3so.class);
                startActivity(intent);
            }
        });

        LinearLayout PhepCongTimSo = findViewById(R.id.phepcongtimso_button);
        PhepCongTimSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdditionActivity.this, Phepcong_Timso.class);
                startActivity(intent);
            }
        });
    }

    private int getLayoutResourceId() {
        return R.layout.activity_addition;
    }
}
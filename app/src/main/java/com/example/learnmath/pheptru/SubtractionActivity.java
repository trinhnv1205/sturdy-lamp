package com.example.learnmath.pheptru;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnmath.R;

public class SubtractionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        LinearLayout BangTruButton = findViewById(R.id.Bangtru_button);
        BangTruButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubtractionActivity.this, Bangtru.class);
                startActivity(intent);
            }
        });

        LinearLayout tru1chusoButton = findViewById(R.id.Chumotchuso_button);
        tru1chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubtractionActivity.this, Tru1_1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout tru2chusoButton = findViewById(R.id.Chuhaichuso_button);
        tru2chusoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubtractionActivity.this, Tru2_1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout TrubasoButton = findViewById(R.id.Trubaso_button);
        TrubasoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubtractionActivity.this, Tru2_2chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout tru3soButton = findViewById(R.id.Trubaso_button);
        tru3soButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubtractionActivity.this, Tru3_1chuso.class);
                startActivity(intent);
            }
        });

        LinearLayout PheptrudongianButton = findViewById(R.id.Pheptrudongian_button);
        PheptrudongianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubtractionActivity.this, Pheptrudongian.class);
                startActivity(intent);
            }
        });
    }

    private int getLayoutResourceId() {
        return R.layout.activity_subtraction;
    }
}
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class AdditionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        LinearLayout multiplicationButton = findViewById(R.id.continuous_addition_button);
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the MultiplicationActivity
                Intent intent = new Intent(AdditionActivity.this, ContinuousAdditionActivity.class);
                startActivity(intent);
            }
        });
    }

    private int getLayoutResourceId() {
        return R.layout.activity_addition;
    }
}
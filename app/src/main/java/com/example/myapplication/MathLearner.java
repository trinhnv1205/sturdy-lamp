package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MathLearner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_math_learner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout additionButton = findViewById(R.id.addition_button);
        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the AdditionActivity
                Intent intent = new Intent(MathLearner.this, AdditionActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout subtractionButton = findViewById(R.id.subtraction_button);
        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SubtractionActivity
                Intent intent = new Intent(MathLearner.this, SubtractionActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout multiplicationButton = findViewById(R.id.multiplication_button);
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the MultiplicationActivity
                Intent intent = new Intent(MathLearner.this, MultiplicationActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout divisionButton = findViewById(R.id.division_button);
        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the DivisionActivity
                Intent intent = new Intent(MathLearner.this, DivisionActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout comparisonButton = findViewById(R.id.comparison_button);
        comparisonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ComparisonActivity
                Intent intent = new Intent(MathLearner.this, ComparisonActivity.class);
                startActivity(intent);
            }
        });


    }
}
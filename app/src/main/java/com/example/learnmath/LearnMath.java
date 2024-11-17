package com.example.learnmath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.learnmath.compares.ComparisonActivity;
import com.example.learnmath.divisions.DivisionActivity;
import com.example.learnmath.entities.AppDatabase;
import com.example.learnmath.multiplications.MultiplicationActivity;
import com.example.learnmath.random.RandomActivity;
import com.example.learnmath.ranks.RankActivity;
import com.example.learnmath.settings.SettingsActivity;
import com.example.learnmath.subtracts.SubtractionActivity;

public class LearnMath extends AppCompatActivity {
    private static AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_database").build();

        setContentView(R.layout.activity_learn_math);
        // Apply the system window insets to the root view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        LinearLayout subtractionButton = findViewById(R.id.subtraction_button);
        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SubtractionActivity
                Intent intent = new Intent(LearnMath.this, SubtractionActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout multiplicationButton = findViewById(R.id.multiplication_button);
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the MultiplicationActivity
                Intent intent = new Intent(LearnMath.this, MultiplicationActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout divisionButton = findViewById(R.id.division_button);
        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the DivisionActivity
                Intent intent = new Intent(LearnMath.this, DivisionActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout comparisonButton = findViewById(R.id.compare_button);
        comparisonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ComparisonActivity
                Intent intent = new Intent(LearnMath.this, ComparisonActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout randomButton = findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the RandomActivity
                Intent intent = new Intent(LearnMath.this, RandomActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout rankButton = findViewById(R.id.rank_button);
        rankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the RankActivity
                Intent intent = new Intent(LearnMath.this, RankActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the RankActivity
                Intent intent = new Intent(LearnMath.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    public static AppDatabase getDatabase() {
        return database;
    }
}
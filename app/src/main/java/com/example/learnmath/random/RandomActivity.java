package com.example.learnmath.random;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.learnmath.additions.AdditionActivity;
import com.example.learnmath.compares.ComparisonActivity;
import com.example.learnmath.divisions.DivisionActivity;
import com.example.learnmath.multiplications.MultiplicationActivity;
import com.example.learnmath.subtracts.SubtractionActivity;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Class<?>[] activities = new Class<?>[]{
                AdditionActivity.class,
                SubtractionActivity.class,
                MultiplicationActivity.class,
                DivisionActivity.class,
                ComparisonActivity.class
        };

        Random random = new Random();
        int index = random.nextInt(activities.length);
        Class<?> selectedActivity = activities[index];

        Intent intent = new Intent(this, selectedActivity);
        startActivity(intent);
        finish();
    }
}
package com.example.learnmath.random;

import android.content.Intent;
import android.os.Bundle;

import com.example.learnmath.BaseQuizActivity;
import com.example.learnmath.compares.ComparisonActivity;
import com.example.learnmath.divisions.DivisionActivity;
import com.example.learnmath.multiplications.MultiplicationActivity;
import com.example.learnmath.subtracts.SubtractionActivity;

import java.util.Random;

public class RandomActivity extends BaseQuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Class<?>[] activities = new Class<?>[]{
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

    @Override
    protected int getLayoutResourceId() {
        return 0;
    }

    @Override
    protected void generateQuestion() {
        // Do nothing
    }
}
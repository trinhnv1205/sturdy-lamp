package com.example.learnmath.ngaunhien;

import android.content.Intent;
import android.os.Bundle;

import com.example.learnmath.BaseQuizActivity;
import com.example.learnmath.sosanh.PhepSoSanhActivity;
import com.example.learnmath.phepchia.MenuPhepChia;
import com.example.learnmath.phepnhan.PhepNhanActivity;
import com.example.learnmath.pheptru.SubtractionActivity;

import java.util.Random;

public class RandomActivity extends BaseQuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Class<?>[] activities = new Class<?>[]{
                SubtractionActivity.class,
                PhepNhanActivity.class,
                MenuPhepChia.class,
                PhepSoSanhActivity.class
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
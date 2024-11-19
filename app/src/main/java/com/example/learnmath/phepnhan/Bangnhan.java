package com.example.learnmath.phepnhan;

import android.widget.Button;

import com.example.learnmath.CauHoiActivity;
import com.example.learnmath.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bangnhan extends CauHoiActivity {

    private int currentMultiplier = 1;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_cau_hoi;
    }

    @Override
    protected void generateQuestion() {
        int baseNumber = 2; // Starting number for multiplication
        correctAnswer = baseNumber * currentMultiplier;
        questionText.setText(baseNumber + " * " + currentMultiplier + " = ?");

        List<Integer> positions = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(positions);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (positions.get(i) == 0) {
                buttons[i].setText(String.valueOf(correctAnswer));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = new Random().nextInt(20) + 1;
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }

        // Update the multiplier for the next question
        currentMultiplier++;
    }
}
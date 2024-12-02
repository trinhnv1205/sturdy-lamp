package com.example.learnmath.phepchia;

import android.widget.Button;

import com.example.learnmath.CauHoiActivity;
import com.example.learnmath.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BangChia extends CauHoiActivity {

    private int currentDivisor = 1;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_bang_phep_tinh;
    }

    @Override
    protected void generateQuestion() {
        int baseNumber = 20; // Starting number for division
        correctAnswer = baseNumber / currentDivisor;
        questionText.setText(baseNumber + " / " + currentDivisor + " = ?");

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
                } while (wrongAnswer == correctAnswer || baseNumber % wrongAnswer != 0);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }

        // Update the divisor for the next question
        currentDivisor++;
    }
}
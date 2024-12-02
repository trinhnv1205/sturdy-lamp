package com.example.learnmath.phepcong;

import android.widget.Button;

import com.example.learnmath.CauHoiActivity;
import com.example.learnmath.R;

import java.util.Random;

public class PhepCongDonGian extends CauHoiActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_bang_phep_tinh;
    }

    @Override
    protected void generateQuestion() {
        Random random = new Random();
        int[] addends1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900};
        int[] addends2 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900};
        int num1 = addends1[random.nextInt(addends1.length)];
        int num2 = addends2[random.nextInt(addends2.length)];
        correctAnswer = num1 + num2;
        questionText.setText(num1 + " + " + num2 + " = ?");

        int correctPosition = random.nextInt(4);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (i == correctPosition) {
                buttons[i].setText(String.valueOf(correctAnswer));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = random.nextInt(2000) + 1; // Range from 1 to 2000
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }
    }
}
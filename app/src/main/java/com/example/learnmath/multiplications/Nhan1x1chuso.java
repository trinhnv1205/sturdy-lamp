package com.example.learnmath.multiplications;

import android.widget.Button;

import com.example.learnmath.BaseQuizActivity;
import com.example.learnmath.R;

import java.util.Random;

public class Nhan1x1chuso extends BaseQuizActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_quiz;
    }

    @Override
    protected void generateQuestion() {
        Random random = new Random();
        int num1 = random.nextInt(9) + 1; // Range from 1 to 9
        int num2 = random.nextInt(9) + 1; // Range from 1 to 9
        correctAnswer = num1 * num2;
        questionText.setText(num1 + " * " + num2 + " = ?");

        int correctPosition = random.nextInt(4);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (i == correctPosition) {
                buttons[i].setText(String.valueOf(correctAnswer));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = random.nextInt(81) + 1; // Range from 1 to 81
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }
    }
}
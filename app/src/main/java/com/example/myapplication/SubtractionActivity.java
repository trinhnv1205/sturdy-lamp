package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class SubtractionActivity extends BaseQuizActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_subtraction;
    }

    @Override
    protected void generateQuestion() {
        Random random = new Random();
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        correctAnswer = num1 - num2;
        questionText.setText(num1 + " - " + num2 + " = ?");

        int correctPosition = random.nextInt(4);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (i == correctPosition) {
                buttons[i].setText(String.valueOf(correctAnswer));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = random.nextInt(20) - 10;
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }
    }
}
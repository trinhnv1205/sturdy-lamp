package com.example.learnmath.pheptru;

import android.widget.Button;

import com.example.learnmath.BaseQuizActivity;
import com.example.learnmath.R;

import java.util.Random;

public class Bangtru extends BaseQuizActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_quiz;
    }

    @Override
    protected void generateQuestion() {
        Random random = new Random();
        int num1, num2, num3;
        do {
            num1 = random.nextInt(90) + 10; // Range from 10 to 99
            num2 = random.nextInt(90) + 10; // Range from 10 to 99
            num3 = random.nextInt(90) + 10; // Range from 10 to 99
        } while (num1 < num2 + num3); // Ensure num1 is greater than or equal to the sum of num2 and num3

        correctAnswer = num1 - num2 - num3;
        questionText.setText(num1 + " - " + num2 + " - " + num3 + " = ?");

        int correctPosition = random.nextInt(4);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (i == correctPosition) {
                buttons[i].setText(String.valueOf(correctAnswer));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = random.nextInt(90); // Range from 0 to 89
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }
    }
}
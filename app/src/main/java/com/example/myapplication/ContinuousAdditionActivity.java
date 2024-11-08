package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class ContinuousAdditionActivity extends BaseQuizActivity {

    private int baseNumber = 1;
    private int currentAddend = 1;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_continuous_addition;
    }

    @Override
    protected void generateQuestion() {
        correctAnswer = baseNumber + currentAddend;
        questionText.setText(baseNumber + " + " + currentAddend + " = ?");

        int correctPosition = new Random().nextInt(4);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (i == correctPosition) {
                buttons[i].setText(String.valueOf(correctAnswer));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = new Random().nextInt(20) + 1;
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }

        // Update the addend for the next question
        currentAddend++;
    }
}
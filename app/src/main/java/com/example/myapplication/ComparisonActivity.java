package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class ComparisonActivity extends BaseQuizActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_comparison;
    }

    @Override
    protected void generateQuestion() {
    Random random = new Random();
    int num1 = random.nextInt(10) + 1;
    int num2 = random.nextInt(10) + 1;
    String comparison;
    if (num1 > num2) {
        comparison = ">";
        correctAnswer = 1;
    } else if (num1 < num2) {
        comparison = "<";
        correctAnswer = -1;
    } else {
        comparison = "=";
        correctAnswer = 0;
    }
    questionText.setText(num1 + " ? " + num2);

    int correctPosition = random.nextInt(4);
    Button[] buttons = {answer1, answer2, answer3, answer4};
    for (int i = 0; i < 4; i++) {
        if (i == correctPosition) {
            buttons[i].setText(comparison);
        } else {
            String wrongAnswer;
            do {
                int rand = random.nextInt(3);
                wrongAnswer = rand == 0 ? ">" : rand == 1 ? "<" : "=";
            } while (wrongAnswer.equals(comparison));
            buttons[i].setText(wrongAnswer);
        }
    }
}
}
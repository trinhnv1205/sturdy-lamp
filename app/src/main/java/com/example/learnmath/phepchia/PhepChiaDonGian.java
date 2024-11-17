package com.example.learnmath.phepchia;

import android.widget.Button;

import com.example.learnmath.BaseQuizActivity;
import com.example.learnmath.R;

import java.util.Random;

public class PhepChiaDonGian extends BaseQuizActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_quiz;
    }

    @Override
    protected void generateQuestion() {
        Random random = new Random();
        int[] dividends = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900};
        int[] divisors = {1, 2, 5, 10};
        int num1, num2;
        do {
            num1 = dividends[random.nextInt(dividends.length)];
            num2 = divisors[random.nextInt(divisors.length)];
        } while (num1 % num2 != 0); // Ensure num1 is divisible by num2

        correctAnswer = num1 / num2;
        questionText.setText(num1 + " / " + num2 + " = ?");

        int correctPosition = random.nextInt(4);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (i == correctPosition) {
                buttons[i].setText(String.valueOf(correctAnswer));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = random.nextInt(1000) + 1; // Range from 1 to 1000
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }
    }
}
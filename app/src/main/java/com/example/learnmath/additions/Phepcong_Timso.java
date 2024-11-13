package com.example.learnmath.additions;

import android.widget.Button;

import com.example.learnmath.BaseQuizActivity;
import com.example.learnmath.R;

import java.util.Random;

public class Phepcong_Timso extends BaseQuizActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_quiz;
    }

    @Override
    protected void generateQuestion() {
        Random random = new Random();
        int num1 = random.nextInt(50) + 1; // Range from 1 to 50
        int num2 = random.nextInt(50) + 1; // Range from 1 to 50
        int missingPosition = random.nextInt(2); // 0 or 1
        correctAnswer2 = num1 + num2;

        if (missingPosition == 0) {

            questionText.setText("? + " + num2 + " = " + correctAnswer2);
        } else {
        
            questionText.setText(num1 + " + ? = " + correctAnswer2);
        }

        int correctPosition = random.nextInt(4);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (i == correctPosition) {
                buttons[i].setText(String.valueOf(missingPosition == 0 ? num1 : num2));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = random.nextInt(50) + 1; // Range from 1 to 50
                } while (wrongAnswer == (missingPosition == 0 ? num1 : num2));
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }
    }
}
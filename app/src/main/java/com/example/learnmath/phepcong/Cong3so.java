package com.example.learnmath.phepcong;

import android.widget.Button;

import com.example.learnmath.CauHoiActivity;
import com.example.learnmath.R;

import java.util.Random;

public class Cong3so extends CauHoiActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_cau_hoi;
    }

    @Override
    protected void generateQuestion() {
        Random random = new Random();
        int num1 = random.nextInt(9) + 1; // Range from 1 to 9
        int num2 = random.nextInt(9) + 1; // Range from 1 to 9
        int num3 = random.nextInt(9) + 1; // Range from 1 to 9
        correctAnswer = num1 + num2 + num3;
        questionText.setText(num1 + " + " + num2 + " + " + num3 + " = ?");

        int correctPosition = random.nextInt(4);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (i == correctPosition) {
                buttons[i].setText(String.valueOf(correctAnswer));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = random.nextInt(27) + 3; // Range from 3 to 29
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }
    }
}
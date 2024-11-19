package com.example.learnmath.pheptru;

import android.widget.Button;

import com.example.learnmath.CauHoiActivity;
import com.example.learnmath.R;

import java.util.Random;

public class TruBaVoiMotChuSo extends CauHoiActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_cau_hoi;
    }

    @Override
    protected void generateQuestion() {
        Random random = new Random();
        int num1, num2;
        do {
            num1 = random.nextInt(900) + 100; // Range from 100 to 999
            num2 = random.nextInt(9) + 1;     // Range from 1 to 9
        } while (num1 < num2); // Ensure num1 is greater than or equal to num2

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
                    wrongAnswer = random.nextInt(900); // Range from 0 to 899
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }
    }
}
package com.example.learnmath.phepcong;

import android.widget.Button;

import com.example.learnmath.CauHoiActivity;
import com.example.learnmath.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CongBaChuSo extends CauHoiActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_bang_phep_tinh;
    }

    @Override
    protected void generateQuestion() {
        Random random = new Random();
        int num1 = random.nextInt(900) + 100; // Range from 100 to 999
        int num2 = random.nextInt(900) + 100; // Range from 100 to 999
        correctAnswer = num1 + num2;
        questionText.setText(num1 + " + " + num2 + " = ?");

        List<Integer> positions = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(positions);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (positions.get(i) == 0) {
                buttons[i].setText(String.valueOf(correctAnswer));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = random.nextInt(1798) + 200; // Range from 200 to 1998
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }
    }
}
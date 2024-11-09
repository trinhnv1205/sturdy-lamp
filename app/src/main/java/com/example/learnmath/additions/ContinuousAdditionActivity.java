package com.example.learnmath.additions;

import android.widget.Button;

import com.example.learnmath.BaseQuizActivity;
import com.example.learnmath.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ContinuousAdditionActivity extends BaseQuizActivity {

    private int currentAddend = 1;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_continuous_addition;
    }

    @Override
    protected void generateQuestion() {
        int baseNumber = 1;
        correctAnswer = baseNumber + currentAddend;
        questionText.setText(baseNumber + " + " + currentAddend + " = ?");

        List<Integer> positions = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(positions);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (positions.get(i) == 0) {
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
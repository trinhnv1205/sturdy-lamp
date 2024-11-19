package com.example.learnmath.luyentap;

import android.widget.Button;

import com.example.learnmath.BaseQuizActivity;
import com.example.learnmath.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LuyenTapToan extends BaseQuizActivity {

    private int currentNumber = 1;
    private Random random = new Random();

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_quiz;
    }

    @Override
    protected void generateQuestion() {
        int baseNumber = random.nextInt(20) + 1; // Random base number between 1 and 20
        int operation = random.nextInt(4); // Randomly select an operation (0: addition, 1: subtraction, 2: multiplication, 3: division)
        String question;

        switch (operation) {
            case 0: // Addition
                correctAnswer = baseNumber + currentNumber;
                question = baseNumber + " + " + currentNumber + " = ?";
                break;
            case 1: // Subtraction
                correctAnswer = baseNumber - currentNumber;
                question = baseNumber + " - " + currentNumber + " = ?";
                break;
            case 2: // Multiplication
                correctAnswer = baseNumber * currentNumber;
                question = baseNumber + " * " + currentNumber + " = ?";
                break;
            case 3: // Division
                correctAnswer = baseNumber / currentNumber;
                question = baseNumber + " / " + currentNumber + " = ?";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }

        questionText.setText(question);

        List<Integer> positions = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(positions);
        Button[] buttons = {answer1, answer2, answer3, answer4};
        for (int i = 0; i < 4; i++) {
            if (positions.get(i) == 0) {
                buttons[i].setText(String.valueOf(correctAnswer));
            } else {
                int wrongAnswer;
                do {
                    wrongAnswer = random.nextInt(40) + 1; // Random wrong answer between 1 and 40
                } while (wrongAnswer == correctAnswer);
                buttons[i].setText(String.valueOf(wrongAnswer));
            }
        }

        // Update the number for the next question

        currentNumber++;
    }
}
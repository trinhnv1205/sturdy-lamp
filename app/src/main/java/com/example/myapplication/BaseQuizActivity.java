package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public abstract class BaseQuizActivity extends AppCompatActivity {

    protected TextView questionText;
    protected TextView feedbackText;
    protected Button retryButton, resetButton, viewScoreButton;
    protected int correctAnswer;
    protected int score = 0;
    protected int questionCount = 0;
    protected Button answer1, answer2, answer3, answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        questionText = findViewById(R.id.question_text);
        feedbackText = findViewById(R.id.feedback_text);
        retryButton = findViewById(R.id.retry_button);
        resetButton = findViewById(R.id.reset_button);
        viewScoreButton = findViewById(R.id.view_score_button);

        // Initialize the Buttons
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        generateQuestion();

        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer((Button) v);
            }
        };

        answer1.setOnClickListener(answerClickListener);
        answer2.setOnClickListener(answerClickListener);
        answer3.setOnClickListener(answerClickListener);
        answer4.setOnClickListener(answerClickListener);

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retryQuiz();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetQuiz();
            }
        });

        viewScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewScore();
            }
        });
    }

    protected abstract int getLayoutResourceId();

    protected abstract void generateQuestion();

    protected void checkAnswer(Button selectedButton) {
        int selectedAnswer = Integer.parseInt(selectedButton.getText().toString());

        if (selectedAnswer == correctAnswer) {
            score++;
            feedbackText.setText("Đúng rồi!");
        } else {
            feedbackText.setText("Sai rồi!");
        }

        questionCount++;
        if (questionCount < 10) {
            generateQuestion();
        } else {
            feedbackText.setText("Trò chơi kết thúc! Tổng điểm là: " + score);
            retryButton.setVisibility(View.VISIBLE);
            resetButton.setVisibility(View.VISIBLE);
            viewScoreButton.setVisibility(View.VISIBLE);
        }
    }

    protected void retryQuiz() {
        score = 0;
        questionCount = 0;
        feedbackText.setText("");
        retryButton.setVisibility(View.GONE);
        resetButton.setVisibility(View.GONE);
        viewScoreButton.setVisibility(View.GONE);
        generateQuestion();
    }

    protected void resetQuiz() {
        score = 0;
        questionCount = 0;
        feedbackText.setText("");
        retryButton.setVisibility(View.GONE);
        resetButton.setVisibility(View.GONE);
        viewScoreButton.setVisibility(View.GONE);
        generateQuestion();
    }

    protected void viewScore() {
        feedbackText.setText("Tổng điểm là: " + score);
    }
}
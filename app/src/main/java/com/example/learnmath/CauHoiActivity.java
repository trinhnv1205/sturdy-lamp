package com.example.learnmath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.learnmath.thucthe.CoSoDuLieu;
import com.example.learnmath.thucthe.NguoiDungTable;

public abstract class CauHoiActivity extends AppCompatActivity {
    protected TextView questionText;
    protected TextView feedbackText;
    protected Button retryButton, viewScoreButton;
    protected int correctAnswer;
    protected int correctAnswer2;
    protected int score = 0;
    protected int questionCount = 0;
    protected Button answer1, answer2, answer3, answer4;
    private CoSoDuLieu database;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showExitConfirmationDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void showExitConfirmationDialog() {
        new AlertDialog.Builder(this).setTitle("Thoát khỏi bài làm").setMessage("Bạn có chắc chắn muốn thoát không?").setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton(android.R.string.no, null).setIcon(R.drawable.ic_canhbao).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());


        database = Room.databaseBuilder(getApplicationContext(), CoSoDuLieu.class, "app_database").build();


        questionText = findViewById(R.id.question_text);
        feedbackText = findViewById(R.id.feedback_text);
        retryButton = findViewById(R.id.retry_button);
        viewScoreButton = findViewById(R.id.view_score_button);

        // Initialize the Buttons
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        generateQuestion();

        View.OnClickListener answerClickListener = v -> checkAnswer((Button) v);

        answer1.setOnClickListener(answerClickListener);
        answer2.setOnClickListener(answerClickListener);
        answer3.setOnClickListener(answerClickListener);
        answer4.setOnClickListener(answerClickListener);

        retryButton.setOnClickListener(v -> retryQuiz());

        viewScoreButton.setOnClickListener(v -> viewScore());
    }

    protected abstract int getLayoutResourceId();

    protected abstract void generateQuestion();


    protected void checkAnswer(Button selectedButton) {
        int selectedAnswer = Integer.parseInt(selectedButton.getText().toString());

        if (selectedAnswer == correctAnswer) {
            score++;
            feedbackText.setText("Chính xác!");
        } else {
            feedbackText.setText("Sai rồi!");
        }

        questionCount++;
        if (questionCount < 10) {
            generateQuestion();
        } else {
            feedbackText.setText("Trò chơi kết thúc! Tổng điểm là: " + score);
            saveScore();
            retryButton.setVisibility(View.VISIBLE);
            viewScoreButton.setVisibility(View.VISIBLE);
        }
    }


    private void saveScore() {
        new Thread(() -> {
            NguoiDungTable nguoiDungTable = new NguoiDungTable();
            nguoiDungTable.name = getRandomName();
            nguoiDungTable.score = score;
            database.userDao().insert(nguoiDungTable);
        }).start();
    }

    private String getRandomName() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 1:
                return "User";
            case 2:
                return "Guest";
            default:
                return "Player";
        }
    }

    protected void retryQuiz() {
        score = 0;
        questionCount = 0;
        feedbackText.setText("");
        retryButton.setVisibility(View.GONE);
        viewScoreButton.setVisibility(View.GONE);
        generateQuestion();
    }

    protected void viewScore() {
        feedbackText.setText("Tổng điểm là: " + score);
    }


}
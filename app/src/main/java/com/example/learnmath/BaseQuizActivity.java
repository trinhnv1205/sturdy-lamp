package com.example.learnmath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.learnmath.thucthe.AppDatabase;
import com.example.learnmath.thucthe.Settings;
import com.example.learnmath.thucthe.User;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;

public abstract class BaseQuizActivity extends AppCompatActivity {
    protected TextView questionText;
    protected TextView feedbackText;
    protected Button retryButton, viewScoreButton;
    protected int correctAnswer;
    protected int correctAnswer2;
    protected int score = 0;
    protected int questionCount = 0;
    protected Button answer1, answer2, answer3, answer4;
    private AppDatabase database;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showExitConfirmationDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //thông báo khi ấn nút back
    private void showExitConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Thoát khỏi bài làm")
                .setMessage("Bạn có chắc chắn muốn thoát không?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(R.drawable.ic_canhbao)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());


        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_database").build();



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


    protected void checkAnswer2(Button selectedButton2) {
        int selectedAnswer2 = Integer.parseInt(selectedButton2.getText().toString());

        if (selectedAnswer2 == correctAnswer2) {
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
            User user = new User();
            user.name = getRandomName();
            user.score = score;
            database.userDao().insert(user);
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
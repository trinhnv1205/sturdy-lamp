package com.example.learnmath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.learnmath.sosanh.PhepSoSanhActivity;
import com.example.learnmath.thucthe.CoSoDuLieu;
import com.example.learnmath.thucthe.NguoiDungTable;

import android.os.Handler;
import android.os.SystemClock;

public abstract class CauHoiActivity extends AppCompatActivity {
    protected TextView questionText;
    protected TextView feedbackText;
    protected Button retryButton, viewScoreButton;
    protected ImageView cupImage;
    protected int correctAnswer;
    protected int correctAnswer2;
    protected int score = 0;
    protected int questionCount = 0;
    protected Button answer1, answer2, answer3, answer4;
    private CoSoDuLieu database;
    private TextView timerText;
    private long startTime = 0L;
    private Handler timerHandler = new Handler();
    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long millis = SystemClock.uptimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            if (timerText != null) {
                timerText.setText(String.format("%02d:%02d", minutes, seconds));
            }

            timerHandler.postDelayed(this, 500);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showExitConfirmationDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //hiển thị dialog thông báo muốn thoát khỏi bài làm
    private void showExitConfirmationDialog() {
        new AlertDialog.Builder(this).setTitle("Thoát khỏi bài làm").setMessage("Bạn có chắc chắn muốn thoát không?").setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton(android.R.string.no, null).setIcon(R.drawable.ic_canhbao).show();
    }

    //khởi tạo bài làm
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        //khởi tạo cơ sở dữ liệu
        database = Room.databaseBuilder(getApplicationContext(), CoSoDuLieu.class, "app_database").addMigrations(CoSoDuLieu.MIGRATION_1_2).build();

        // lấy id của các textview
        questionText = findViewById(R.id.question_text);
        feedbackText = findViewById(R.id.feedback_text);
        retryButton = findViewById(R.id.retry_button);
        viewScoreButton = findViewById(R.id.view_score_button);
        timerText = findViewById(R.id.timer_text);//hiển thị thời gian


        // lấy id của các button
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

        startTimer();
    }

    //bắt đầu đếm thời gian
    private void startTimer() {
        startTime = SystemClock.uptimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);
    }

    //dừng đếm thời gian
    private void stopTimer() {
        timerHandler.removeCallbacks(timerRunnable);
    }


    //lấy layout cho từng bài làm
    protected abstract int getLayoutResourceId();

    //tạo câu hỏi
    protected abstract void generateQuestion();

    // để kiểm tra tính đúng sai của các phép tính
    protected void checkAnswer(Button selectedButton) {
        String selectedAnswer = selectedButton.getText().toString();
        boolean isCorrect = false;

        if (this instanceof PhepSoSanhActivity) {
            isCorrect = ((PhepSoSanhActivity) this).isAnswerCorrect(selectedAnswer);
        } else {
            isCorrect = selectedAnswer.equals(String.valueOf(correctAnswer));
        }

        if (isCorrect) {
            score++;
            feedbackText.setText("Chính xác!");
        } else {
            feedbackText.setText("Sai rồi!");
        }

        questionCount++;
        if (questionCount < 10) {
            generateQuestion();
        } else {
            stopTimer();//dừng đếm thời gian
            saveScore();//lưu điểm số
            retryButton.setVisibility(View.VISIBLE);
            viewScoreButton.setVisibility(View.VISIBLE);
        }

    }

    //lưu điểm số của người dùng
    private void saveScore() {
        new Thread(() -> {
            NguoiDungTable nguoiDungTable = new NguoiDungTable();
            nguoiDungTable.name = getRandomName();
            nguoiDungTable.score = score;
            nguoiDungTable.time = timerText.getText().toString();
            database.userDao().insert(nguoiDungTable);

        }).start();
    }


    //lấy tên ngẫu nhiên cho người dùng
    private String getRandomName() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 1:
                return "Oanh Xinh Gái";
            case 2:
                return "Linh Hâm Hấp";
            default:
                return "Khúc Dịu Dàng";
        }
    }

    //khởi tạo lại bài làm
    protected void retryQuiz() {
        score = 0;
        questionCount = 0;
        feedbackText.setText("");
        retryButton.setVisibility(View.GONE);
        viewScoreButton.setVisibility(View.GONE);
        generateQuestion();
        startTimer();
    }

    //hiển thị điểm số của người dùng
    protected void viewScore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_view_score, null);
        builder.setView(dialogView);

        TextView scoreText = dialogView.findViewById(R.id.score_text);
        TextView timeText = dialogView.findViewById(R.id.time_text);
        ImageView cupImage = dialogView.findViewById(R.id.cup_image);

        scoreText.setText("Tổng điểm của bạn là: " + score);
        timeText.setText("Thời gian làm bài: " + timerText.getText());

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        database.close();
        super.onDestroy();
    }
}
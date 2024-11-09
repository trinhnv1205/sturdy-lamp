package com.example.learnmath.ranks;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.learnmath.R;
import com.example.learnmath.entities.User;
import com.example.learnmath.entities.UserAdapter;
import com.example.learnmath.entities.UserDao;
import com.example.learnmath.LearnMath;
import java.util.List;

public class RankActivity extends AppCompatActivity {
    private UserDao userDao;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        userDao = LearnMath.getDatabase().userDao();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new Thread(() -> {
            List<User> users = userDao.getAllUsers();
            runOnUiThread(() -> {
                userAdapter = new UserAdapter(users);
                recyclerView.setAdapter(userAdapter);
            });
        }).start();
    }
}
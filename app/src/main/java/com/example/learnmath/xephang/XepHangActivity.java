package com.example.learnmath.xephang;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnmath.ManHinhChinh;
import com.example.learnmath.R;
import com.example.learnmath.thucthe.User;
import com.example.learnmath.thucthe.UserAdapter;
import com.example.learnmath.thucthe.UserDao;

import java.util.List;

public class XepHangActivity extends AppCompatActivity {
    private UserDao userDao;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_xep_hang);

        userDao = ManHinhChinh.getDatabase().userDao();
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
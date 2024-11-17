package com.example.learnmath.thucthe;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Query("SELECT * FROM user ORDER BY score DESC")
    List<User> getAllUsers();
}

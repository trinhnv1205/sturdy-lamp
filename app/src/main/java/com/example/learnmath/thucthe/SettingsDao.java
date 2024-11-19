package com.example.learnmath.thucthe;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SettingsDao {
    @Update
    void update(com.example.learnmath.thucthe.Settings settings);

    @Query("SELECT * FROM settings WHERE id = :id LIMIT 1")
    com.example.learnmath.thucthe.Settings getSettings(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(com.example.learnmath.thucthe.Settings settings);
}
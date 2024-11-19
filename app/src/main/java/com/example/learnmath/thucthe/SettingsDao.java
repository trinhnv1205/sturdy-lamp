package com.example.learnmath.thucthe;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SettingsDao {
    @Update
    void update(CaiDatTable caiDatTable);

    @Query("SELECT * FROM CaiDatTable WHERE id = :id LIMIT 1")
    CaiDatTable getSettings(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CaiDatTable caiDatTable);
}
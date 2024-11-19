package com.example.learnmath.thucthe;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NguoiDungDao {
    @Insert
    void insert(NguoiDungTable nguoiDungTable);

    @Query("SELECT * FROM NguoiDungTable ORDER BY score DESC")
    List<NguoiDungTable> getAllUsers();
}
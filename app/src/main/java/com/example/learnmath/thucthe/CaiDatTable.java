package com.example.learnmath.thucthe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CaiDatTable")
public class CaiDatTable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "music_enabled")
    public boolean musicEnabled;
}
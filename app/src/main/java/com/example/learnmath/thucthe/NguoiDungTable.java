package com.example.learnmath.thucthe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "NguoiDungTable")
public class NguoiDungTable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "score")
    public int score;

    @ColumnInfo(name = "time")
    public String time; // Add a new column for time

    @Ignore
    public NguoiDungTable(int id, String name, int score, String time) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.time = time;
    }

    public NguoiDungTable() {
        this.id = 0;
        this.name = "";
        this.score = 0;
        this.time = "";
    }
}
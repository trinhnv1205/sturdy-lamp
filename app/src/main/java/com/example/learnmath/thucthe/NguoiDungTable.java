package com.example.learnmath.thucthe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "NguoiDungTable")
public class NguoiDungTable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "score")
    public int score;

    public NguoiDungTable(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public NguoiDungTable() {
        this.id = 0;
        this.name = "";
        this.score = 0;
    }
}
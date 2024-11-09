package com.example.learnmath.entities;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// AppDatabase.java
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
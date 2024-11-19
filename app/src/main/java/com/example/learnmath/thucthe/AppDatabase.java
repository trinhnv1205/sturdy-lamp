package com.example.learnmath.thucthe;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Settings.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract SettingsDao settingsDao();
}
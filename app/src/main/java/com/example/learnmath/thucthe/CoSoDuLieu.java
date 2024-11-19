package com.example.learnmath.thucthe;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {NguoiDungTable.class, CaiDatTable.class}, version = 1)
public abstract class CoSoDuLieu extends RoomDatabase {
    public abstract NguoiDungDao userDao();
    public abstract SettingsDao settingsDao();
}
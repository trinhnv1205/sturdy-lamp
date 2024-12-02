package com.example.learnmath.thucthe;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {NguoiDungTable.class, CaiDatTable.class}, version = 2, exportSchema = false)
public abstract class CoSoDuLieu extends RoomDatabase {
    public abstract NguoiDungDao userDao();
    public abstract SettingsDao settingsDao();


    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Perform necessary migration steps
            database.execSQL("ALTER TABLE NguoiDungTable ADD COLUMN time TEXT");
        }
    };
}
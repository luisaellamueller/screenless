package com.io.screenless;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.io.screenless.screentimemanagement.adapter.out.persistence.UserDao;
import com.io.screenless.screentimemanagement.adapter.out.persistence.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}


package com.io.screenless;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.io.screenless.screentimemanagement.model.UserDao;
import com.io.screenless.screentimemanagement.model.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

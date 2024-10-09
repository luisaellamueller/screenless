package com.io.screenless.screentimemanagement.controller;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.io.screenless.AppDatabase;
import com.io.screenless.screentimemanagement.model.UserEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserController {

    private AppDatabase db;
    private static final String TAG = "UserController";
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public UserController(Context context) {
        // Initialize Room database
        db = Room.databaseBuilder(context, AppDatabase.class, "app_database")
                .fallbackToDestructiveMigration()
                .build();
    }

    public void insertTestUser() {
        executorService.execute(() -> {
            UserEntity user = new UserEntity();
            user.setFirstName("John");
            user.setLastName("Doe");
            user.setEmail("john.doe@example.com");
            user.setPhoneNumber("1234567890");
            user.setPassword("password123");

            db.userDao().insertUser(user);
            Log.d(TAG, "Inserted new user: " + user.getFirstName() + " " + user.getLastName());
        });
    }

    public void clearDatabase() {
        executorService.execute(() -> {
            db.userDao().deleteAllUsers();
            Log.d(TAG, "All users have been deleted from the database");
        });
    }

    public void findUserById(int userId) {
        executorService.execute(() -> {
            UserEntity user = db.userDao().findUserById(userId);
            if (user != null) {
                Log.d(TAG, "User found: " + user.getFirstName() + " " + user.getLastName());
            } else {
                Log.d(TAG, "User not found");
            }
        });
    }
}

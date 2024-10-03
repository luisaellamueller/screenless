package com.io.screenless;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import com.io.screenless.screentimemanagement.adapter.out.persistence.UserEntity;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the Room database
        db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "app_database")
                .fallbackToDestructiveMigration()
                .build();

        // Clear the database and insert the test user
        clearDatabaseAndInsertTestUser();
    }

    private void clearDatabaseAndInsertTestUser() {
        // Using a latch to ensure that database clear completes before insertion
        CountDownLatch latch = new CountDownLatch(1);

        // Clear the database
        Executors.newSingleThreadExecutor().execute(() -> {
            db.userDao().deleteAllUsers();
            Log.d(TAG, "All users have been deleted from the database");
            latch.countDown();  // Signal that clearing is complete
        });

        // Insert the test user after clearing
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                latch.await();  // Wait for the database clear to finish
                UserEntity user = new UserEntity();
                user.setFirstName("John");
                user.setLastName("Doe");
                user.setEmail("john.doe@example.com");
                user.setPhoneNumber("1234567890");
                user.setPassword("password123");
                db.userDao().insertUser(user);
                Log.d(TAG, "Inserted new user: " + user.getFirstName() + " " + user.getLastName());
            } catch (InterruptedException e) {
                Log.e(TAG, "Error waiting for database clear", e);
            }
        });
    }
}

package com.io.screenless.screentimemanagement.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(UserEntity user);

    @Query("SELECT * FROM users WHERE userId = :userId")
    UserEntity findUserById(Integer userId);

    @Query("DELETE FROM users")
    void deleteAllUsers();
}

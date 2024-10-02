package com.io.screenless.screentimemanagement.adapter.out.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(UserEntity user);

    @Update
    void updateUser(UserEntity user);

    @Delete
    void deleteUser(UserEntity user);

    @Query("SELECT * FROM users WHERE userId = :userId")
    UserEntity findUserById(Integer userId);

    @Query("SELECT * FROM users WHERE email = :email")
    UserEntity findUserByEmail(String email);

    @Query("SELECT * FROM users")
    List<UserEntity> getAllUsers();

    @Query("SELECT EXISTS(SELECT * FROM users WHERE email = :email)")
    boolean existsByEmail(String email);

    @Query("SELECT EXISTS(SELECT * FROM users WHERE phoneNr = :phoneNr)")
    boolean existsByPhoneNr(String phoneNr);

    // New method to delete all users
    @Query("DELETE FROM users")
    void deleteAllUsers();
}

package com.io.screenless.screentimemanagement.view;

import com.io.screenless.screentimemanagement.model.UserEntity;

public interface UserView {
    void onUserInserted(UserEntity user);
    void onDatabaseCleared();
    void onUserFound(UserEntity user);
    void onUserNotFound();
}

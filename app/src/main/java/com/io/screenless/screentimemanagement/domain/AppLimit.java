package com.io.screenless.screentimemanagement.domain;

import android.os.Build;
import androidx.annotation.RequiresApi;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Duration;
import java.time.LocalDate;

@RequiresApi(api = Build.VERSION_CODES.O)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppLimit {

    // Fields (attributes)
    private Integer id;
    private Integer userId;
    private String appName;
    private boolean isActive;
    private LocalDate activationDate;  // The date when the limit was activated

    // Minimum duration of one month (30 days)
    private static final Duration ONE_MONTH = Duration.ofDays(30);

    // Set the time limit for an app
    public void setAppLimit() {
        this.isActive = true;
        this.activationDate = LocalDate.now();  // Set the activation date to the current date
    }

    // Check if the limit has reached the 1-month period
    public boolean isOneMonthCompleted() {
        return LocalDate.now().isAfter(this.activationDate.plusDays(30));
    }

    // Handle what happens after one month (notification, extension, or deactivation)
    public void handleLimitAfterOneMonth() {
        if (isOneMonthCompleted()) {
            // Create a notification for the user
            Notification notification = new Notification(userId, "Your app limit for " + appName + " is about to expire. Would you like to extend it for one more month?");
            notification.send();

            // Ask the user if they want to extend the limit
            boolean userAgrees = notification.askForConfirmation(appName);

            // Extend or deactivate based on user response
            extendLimitIfUserAgrees(userAgrees);
        }
    }

    // Method to extend the limit by one more month or deactivate it based on user's response
    public void extendLimitIfUserAgrees(boolean userAgrees) {
        if (userAgrees) {
            // Extend the limit for another month
            this.activationDate = LocalDate.now();
            this.isActive = true;
            System.out.println("The app limit has been extended for one more month.");
        } else {
            // Set the limit to inactive
            this.isActive = false;
            System.out.println("The app limit has been deactivated.");
        }
    }

    // Activate the limit for the app
    public void activateLimit() {
        this.isActive = true;
        this.activationDate = LocalDate.now();  // Record the activation date
    }

    // Deactivate the limit for the app after the 1-month period has passed
    public void deactivateLimitAfterOneMonth() {
        if (isOneMonthCompleted()) {
            this.isActive = false;
            System.out.println("The app limit has been deactivated after one month.");
        }
    }
}

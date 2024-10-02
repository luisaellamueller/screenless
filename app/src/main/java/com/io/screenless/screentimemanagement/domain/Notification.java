package com.io.screenless.screentimemanagement.domain;

public class Notification {

    private Integer userId;
    private String message;

    // Constructor
    public Notification(Integer userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    // Send notification to the user (this is a simulated example)
    public void send() {
        // Simulate sending a notification
        System.out.println("Notification sent to userId: " + userId + ". Message: " + message);
    }

    // Simulate asking for user input and return true if the user agrees
    public boolean askForConfirmation(String appName) {
        // Logic to ask the user if they want to extend the limit
        System.out.println("Ask user " + userId + " if they want to extend the limit for " + appName);

        // For this example, we'll return true as if the user agreed.
        // In a real scenario, we would show a dialog to get actual user input.
        return true;  // Placeholder for user confirmation
    }
}

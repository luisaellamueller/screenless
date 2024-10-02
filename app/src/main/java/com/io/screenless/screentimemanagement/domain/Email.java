package com.io.screenless.screentimemanagement.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Email {

    // E-Mail-Adresse des Benutzers
    private String emailAddress;

    // Konstruktor, der eine E-Mail-Adresse übernimmt und überprüft, ob sie gültig ist
    public Email(String emailAddress) {
        setEmailAddress(emailAddress); // Set the email address using the setter to ensure validation
    }

    // Custom setter methode
    public void setEmailAddress(String emailAddress) {
        validateEmail(emailAddress);
        this.emailAddress = emailAddress;
    }

    // Methode zur Validierung der E-Mail-Adresse
    private void validateEmail(String emailAddress) {
        if (emailAddress == null || !emailAddress.contains("@")) {
            throw new IllegalArgumentException("Ungültige E-Mail-Adresse. Bitte geben Sie eine gültige E-Mail-Adresse ein.");
        }
    }

    // String-Repräsentation der E-Mail-Adresse
    @Override
    public String toString() {
        return emailAddress;
    }
}

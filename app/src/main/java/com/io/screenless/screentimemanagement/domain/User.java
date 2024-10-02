package com.io.screenless.screentimemanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // Vorname des Benutzers
    private String firstName;

    // Nachname des Benutzers
    private String lastName;

    // E-Mail-Adresse des Benutzers (als Email-Objekt)
    private Email email;

    // Telefonnummer des Benutzers
    private String phoneNumber;

    // Passwort des Benutzers (wird sicher gespeichert)
    private String password;

    // Eine gültige Telefonnummer besteht aus 10 Ziffern
    public boolean isValidPhoneNumber() {
        return phoneNumber != null && phoneNumber.matches("\\d{10}");
    }

    // Beide Passwörter müssen gleich sein, um die Gültigkeit zu bestätigen
    public boolean isPasswordValid(String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }
}

package de.htwberlin.user_management_api;

public class InvalidNameException extends Exception {
    public InvalidNameException(String msg) {
        super(msg);
    }
}

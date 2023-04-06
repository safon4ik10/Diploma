package ru.netology.exception;

public class AuthException extends RuntimeException {
    public AuthException() {
        super("Not authorized");
    }
}

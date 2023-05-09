package ru.netology.javaqa;

public class AlreadyExistsException extends RuntimeException {
    AlreadyExistsException(String message) {
        super(message);
    }
}

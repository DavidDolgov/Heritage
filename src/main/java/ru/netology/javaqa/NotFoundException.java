package ru.netology.javaqa;

public class NotFoundException extends RuntimeException {
    NotFoundException(String message) {
        super(message);
    }
}

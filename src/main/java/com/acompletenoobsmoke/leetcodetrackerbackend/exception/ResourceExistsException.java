package com.acompletenoobsmoke.leetcodetrackerbackend.exception;

public class ResourceExistsException extends RuntimeException {
    public ResourceExistsException(String message) {
        super(message);
    }
    public ResourceExistsException(String message, Throwable cause) {}
}

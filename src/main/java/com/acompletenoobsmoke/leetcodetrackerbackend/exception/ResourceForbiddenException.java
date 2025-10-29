package com.acompletenoobsmoke.leetcodetrackerbackend.exception;

public class ResourceForbiddenException extends RuntimeException {
    public ResourceForbiddenException(String message) {
        super(message);
    }
    public ResourceForbiddenException(String message, Throwable cause) {}
}

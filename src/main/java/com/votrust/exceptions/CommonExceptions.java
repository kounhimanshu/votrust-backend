package com.votrust.exceptions;

public class CommonExceptions {

    public static class ResourceAlreadyExistException extends RuntimeException {
        public ResourceAlreadyExistException(String message) {
            super(message);
        }
    }

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(Object id, String message) {
            super("Resource with ID " + id + " not found. " + message);
        }
    }

    public static class UnauthorizedAccessException extends RuntimeException {
        public UnauthorizedAccessException(String message) {
            super(message);
        }
    }
}

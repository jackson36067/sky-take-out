package com.jackson.exception;

public class PasswordErrorException extends BaseException{
    public PasswordErrorException() {
    }

    public PasswordErrorException(String message) {
        super(message);
    }
}

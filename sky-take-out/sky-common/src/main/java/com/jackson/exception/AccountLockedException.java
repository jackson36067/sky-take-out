package com.jackson.exception;

public class AccountLockedException extends BaseException{
    public AccountLockedException() {
    }

    public AccountLockedException(String message) {
        super(message);
    }
}

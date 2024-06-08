package com.progresssoft.deals.exception;

import lombok.Getter;

@Getter
public class UnknownException extends RuntimeException {
    public UnknownException(String message) {
        super(message);
    }

    public UnknownException(String message, Throwable cause) {
        super(message, cause);
    }
}

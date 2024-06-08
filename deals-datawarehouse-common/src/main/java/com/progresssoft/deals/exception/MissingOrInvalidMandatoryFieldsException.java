package com.progresssoft.deals.exception;

import lombok.Getter;

@Getter
public class MissingOrInvalidMandatoryFieldsException extends RuntimeException {
    public MissingOrInvalidMandatoryFieldsException(String message) {
        super(message);
    }

    public MissingOrInvalidMandatoryFieldsException(String message, Throwable cause) {
        super(message, cause);
    }
}

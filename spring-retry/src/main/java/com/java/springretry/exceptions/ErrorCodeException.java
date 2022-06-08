package com.java.springretry.exceptions;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class ErrorCodeException extends RuntimeException{

    private final String errorCode;

    public ErrorCodeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCodeException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCodeException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorCodeWithoutPrefix() {
        if (errorCode == null) {
            return null;
        }
        return errorCode.replaceFirst("\\D*", "");
    }

}

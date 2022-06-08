package com.java.springretry.exceptions;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class TechnicalException extends ErrorCodeException {

    public TechnicalException(String errorCode) {
        super(errorCode);
    }

    public TechnicalException(String message, String errorCode) {
        super(message, errorCode);
    }

    public TechnicalException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }

    public TechnicalException(Throwable cause, String errorCode) {
        super(cause, errorCode);
    }

}

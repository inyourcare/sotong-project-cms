package com.sotong.projectcms.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParamException extends RuntimeException{
    @Builder
    public InvalidParamException(String message) {
        super(message);
    }

    //@Builder
    public InvalidParamException(String message, Throwable cause) {
        super(message, cause);
    }
}

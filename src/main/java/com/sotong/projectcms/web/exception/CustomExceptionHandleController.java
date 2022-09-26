package com.sotong.projectcms.web.exception;

import com.sotong.projectcms.exception.InvalidParamException;
import com.sotong.projectcms.web.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CustomExceptionHandleController {
    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<Object> handle(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        ex.printStackTrace();
        ApiResponse basicResponse = new ApiResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
        if (ex instanceof NullPointerException) {
            return new ResponseEntity<>(basicResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(basicResponse, HttpStatus.BAD_REQUEST);
    }
}

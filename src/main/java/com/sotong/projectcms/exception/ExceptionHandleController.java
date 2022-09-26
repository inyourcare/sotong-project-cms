package com.sotong.projectcms.exception;

import com.sotong.projectcms.web.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandleController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex, HttpServletRequest request, HttpServletResponse response) {
//        ApiResponse basicResponse = ApiResponse.builder()
//                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .message(ex.getMessage())
//                .count(0).result(null).build();
        ex.printStackTrace();
        ApiResponse basicResponse = new ApiResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        if (ex instanceof NullPointerException) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(basicResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(basicResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

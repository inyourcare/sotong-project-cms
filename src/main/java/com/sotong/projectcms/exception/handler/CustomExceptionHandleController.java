package com.sotong.projectcms.exception.handler;

import com.sotong.projectcms.exception.InvalidParamException;
import com.sotong.projectcms.web.cmmn.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.ServletException;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class CustomExceptionHandleController {
    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<Object> handleInvalidParamException(InvalidParamException e) {
        e.printStackTrace();
        ApiResponse basicResponse = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(basicResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> handleBidingException(BindException e) {
        e.printStackTrace();
        ApiResponse basicResponse = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(basicResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ServletException.class)
    public ResponseEntity<Object> handleServletException(ServletException e) {
        e.printStackTrace();
        ApiResponse basicResponse = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(basicResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     *  javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     *  HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        ApiResponse basicResponse = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(basicResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * enum type 일치하지 않아 binding 못할 경우 발생
     * 주로 @RequestParam enum으로 binding 못했을 경우 발생
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        e.printStackTrace();
        ApiResponse basicResponse = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(basicResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        e.printStackTrace();
        ApiResponse basicResponse = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(basicResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException e) {
        e.printStackTrace();
        ApiResponse basicResponse = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(basicResponse, HttpStatus.UNAUTHORIZED);
    }
}

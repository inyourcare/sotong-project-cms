package com.sotong.projectcms.web.cmmn.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private Integer code;
    private HttpStatus httpStatus;
    private String message;
    private Integer count;
    private List<Object> result;

    public ApiResponse(String msg,HttpStatus code) {
        this.code = code.value();
        this.message = msg;
        this.count = 0;
        this.result = null;
    }
}

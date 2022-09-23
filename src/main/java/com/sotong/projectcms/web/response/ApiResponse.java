package com.sotong.projectcms.web.response;

import lombok.Builder;
import lombok.Data;

@Data
public class ApiResponse {
    private Boolean success;
    private String message;
    private Object result;

    @Builder
    public ApiResponse(Boolean success, String message, Object result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public ApiResponse(RuntimeException e){
        this.success = false;
        this.message = e.getMessage();
    }
}

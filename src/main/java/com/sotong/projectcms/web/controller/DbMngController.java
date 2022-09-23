package com.sotong.projectcms.web.controller;

import com.sotong.projectcms.web.response.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DbMngController {
    @RequestMapping(path = "/createDatabase", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity test() throws Exception {
        return ResponseEntity.ok().body(ApiResponse.builder().success(true).build());
    }
}

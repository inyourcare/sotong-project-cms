package com.sotong.projectcms.web.controller;

import com.sotong.projectcms.service.DbMngService;
import com.sotong.projectcms.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class DbMngController {
    @Autowired
    DbMngService dbMngService;
    @RequestMapping(path = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity test() throws Exception {
        dbMngService.testQuery();
        return ResponseEntity.ok().body(ApiResponse.builder().success(true).build());
    }
}

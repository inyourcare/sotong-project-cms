package com.sotong.projectcms.web.controller;

import com.sotong.projectcms.service.DbMngService;
import com.sotong.projectcms.web.request.CmmnRequest;
import com.sotong.projectcms.web.request.CreateTableRequest;
import com.sotong.projectcms.web.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class DbMngController {
    @Autowired
    DbMngService dbMngService;
    @RequestMapping(path = "/test", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity test(@Valid @RequestBody CmmnRequest req) throws Exception {
//        if (member.isPresent()) {
//            basicResponse = BasicResponse.builder()
//                    .code(HttpStatus.OK.value())
//                    .httpStatus(HttpStatus.OK)
//                    .message("사용자 조회 성공")
//                    .result(Arrays.asList(member.get()))
//                    .count(1).build();
//
//        } else {
//            basicResponse = BasicResponse.builder()
//                    .code(HttpStatus.NOT_FOUND.value())
//                    .httpStatus(HttpStatus.NOT_FOUND)
//                    .message("사용자를 찾을 수 없습니다.")
//                    .result(Collections.emptyList())
//                    .count(0).build();
//
//        }
//
//        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
//        BasicResponse basicResponse = BasicResponse.builder()
//                .code(HttpStatus.OK.value())
//                .httpStatus(HttpStatus.OK)
//                .message("전체 사용자 조회 성공")
//                .result(new ArrayList<>(memberList))
//                .count(memberList.size()).build();
//
//        return new ResponseEntity<>(basicResponse, HttpStatus.OK);
        dbMngService.testQuery(req);

//        ApiResponse basicResponse = ApiResponse.builder()
//                .code(HttpStatus.OK.value())
//                .httpStatus(HttpStatus.OK)
//                .message("Test successfully done")
//                .count(0).result(null).build();
        return new ResponseEntity<>(new ApiResponse("Test successfully done",HttpStatus.OK), HttpStatus.OK);
    }
    @RequestMapping(path = "/createTable", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTable(@Valid @RequestBody CreateTableRequest req) throws Exception {
        dbMngService.createTable(req);
        return new ResponseEntity<>(new ApiResponse("createTable successfully done",HttpStatus.OK), HttpStatus.OK);
    }
}

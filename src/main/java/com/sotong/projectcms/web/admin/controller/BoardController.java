package com.sotong.projectcms.web.admin.controller;

import com.sotong.projectcms.business.service.board.BoardService;
import com.sotong.projectcms.config.anotation.AdminController;
import com.sotong.projectcms.web.admin.controller.parent.AdminAbstractController;
import com.sotong.projectcms.web.admin.form.BoardForm;
import com.sotong.projectcms.web.cmmn.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@AdminController
@RequestMapping("/admin")
public class BoardController extends AdminAbstractController {
    @Autowired
    private BoardService boardService;
    @RequestMapping(path = "/addNewBoard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createNewBoard(@Valid @RequestBody BoardForm form) throws Exception {
        boardService.createNewBoard(form);
        return new ResponseEntity<>(new ApiResponse("createTable successfully done", HttpStatus.OK), HttpStatus.OK);
    }
}

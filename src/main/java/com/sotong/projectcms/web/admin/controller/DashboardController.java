package com.sotong.projectcms.web.admin.controller;

import com.sotong.projectcms.config.anotation.AdminController;
import com.sotong.projectcms.web.admin.controller.parent.AdminAbstractController;
import com.sotong.projectcms.web.request.CreateTableRequest;
import com.sotong.projectcms.web.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Samuel Butta
 */
@AdminController
@RequestMapping("/admin")
public class DashboardController extends AdminAbstractController {

    @RequestMapping
    public String renderIndex() {
        return redirect("/admin/dashboard");
    }

    @RequestMapping("/dashboard")
    public String renderDashboard() {
        return "admin/dashboard";
    }

    @RequestMapping(path = "/createTable", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTable(@Valid @RequestBody CreateTableRequest req) throws Exception {
//        dbMngService.createTable(req);
        return new ResponseEntity<>(new ApiResponse("createTable successfully done", HttpStatus.OK), HttpStatus.OK);
    }

}

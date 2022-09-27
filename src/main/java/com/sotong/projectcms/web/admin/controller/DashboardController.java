package com.sotong.projectcms.web.admin.controller;

import com.sotong.projectcms.config.anotation.AdminController;
import com.sotong.projectcms.web.admin.controller.parent.AdminAbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

}

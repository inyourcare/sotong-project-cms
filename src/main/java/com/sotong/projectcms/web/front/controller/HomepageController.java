package com.sotong.projectcms.web.front.controller;

import com.sotong.projectcms.config.anotation.FrontController;
import com.sotong.projectcms.web.front.controller.parent.FrontAbstractController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Samuel Butta
 */
@FrontController
public class HomepageController extends FrontAbstractController {


    @RequestMapping("/")
    public String index(Model model) {
        addPageData(model, "homepage");

        return "front/index";
    }

}

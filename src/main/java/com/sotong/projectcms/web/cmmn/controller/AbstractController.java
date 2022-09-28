package com.sotong.projectcms.web.cmmn.controller;

public class AbstractController {

    public String redirect(String url) {
        return "redirect:" + url;
    }

}

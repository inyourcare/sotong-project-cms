package com.sotong.projectcms.web.cmmn.controller;

/**
 * @author Samuel Butta
 */
public class AbstractController {

    public String redirect(String url) {
        return "redirect:" + url;
    }

}

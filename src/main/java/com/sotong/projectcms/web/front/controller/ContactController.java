package com.sotong.projectcms.web.front.controller;

import com.sotong.projectcms.config.anotation.FrontController;
import com.sotong.projectcms.web.front.controller.parent.FrontAbstractController;
import com.sotong.projectcms.web.front.form.ContactForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Samuel Butta
 */

@Slf4j
@FrontController
public class ContactController extends FrontAbstractController {

//    private NotificationService notificationService;

//    @Autowired
//    public ContactController(NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }

    @RequestMapping(value = "/contacts")
    public String order(Model model, ContactForm contactForm) {
        addPageData(model, "contacts");
        return "front/contact";
    }


    @PostMapping(value = "/contacts/send")
    public String sendOrder(@Valid ContactForm contactForm, BindingResult bindingResult) {
        log.info("order form was send with data {}", contactForm);
        // TODO send email

        // TODO save to notifications
//        notificationService.notify("new contact form sent");
//
        return redirect("/contacts");
    }


}

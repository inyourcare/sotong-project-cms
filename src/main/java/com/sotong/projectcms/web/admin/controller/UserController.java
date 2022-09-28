package com.sotong.projectcms.web.admin.controller;

import com.sotong.projectcms.config.anotation.AdminController;
import com.sotong.projectcms.persistence.entity.auth.User;
import com.sotong.projectcms.persistence.entity.auth.type.UserState;
import com.sotong.projectcms.persistence.repository.auth.UserRepository;
import com.sotong.projectcms.web.admin.controller.parent.AdminAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Samuel Butta
 */

@AdminController
@RequestMapping("admin/users")
public class UserController extends AdminAbstractController {


    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/all")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "/admin/all";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam Long userId) {
        System.out.println(userId);

        // delete user
        User user = userRepository.getReferenceById(userId);

        user.setState(UserState.STATE_LEAVED);
        userRepository.save(user);

        return redirect("/admin/users/all");
    }

}

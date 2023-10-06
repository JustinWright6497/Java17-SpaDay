package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    private UserData userData = new UserData();

    @GetMapping("add")
    public String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (user.getPassword().equals(verify)) {
            userData.addUser(user);
            model.addAttribute("userData", userData.getAll());
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords must match");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }
    }

}
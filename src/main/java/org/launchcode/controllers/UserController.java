package org.launchcode.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors) {
        if (errors.hasFieldErrors("username")) {
            model.addAttribute("errors", errors.getFieldError("username").getDefaultMessage());
            return "user/add";
        }
        else if (errors.hasFieldErrors("verifyPassword")){
            model.addAttribute("errors", errors.getFieldError("verifyPassword").getDefaultMessage());
            return "user/add";
        }
        else {
            return "user/index";
        }

    }

}
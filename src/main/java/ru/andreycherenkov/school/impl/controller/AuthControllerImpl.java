package ru.andreycherenkov.school.impl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ru.andreycherenkov.school.api.Pages;
import ru.andreycherenkov.school.api.controller.AuthController;
import ru.andreycherenkov.school.db.entity.User;

@Controller
public class AuthControllerImpl implements AuthController {

    @Override
    public String login() {
        return Pages.LOGIN_PAGE;
    }

    @Override
    public String registration() {
        return Pages.REGISTRATION_PAGE;
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        return "redirect:/login";
    }
}

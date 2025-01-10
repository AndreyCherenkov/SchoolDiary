package ru.andreycherenkov.school.impl.controller;

import org.springframework.stereotype.Controller;
import ru.andreycherenkov.school.api.Pages;
import ru.andreycherenkov.school.api.controller.AuthController;

@Controller
public class AuthControllerImpl implements AuthController {

    @Override
    public String login() {
        return Pages.LOGIN_PAGE;
    }
}

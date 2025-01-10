package ru.andreycherenkov.school.impl.controller;

import org.springframework.stereotype.Controller;
import ru.andreycherenkov.school.api.controller.GeneralController;

@Controller
public class GeneralControllerImpl implements GeneralController {

    @Override
    public String getIndex() {
        return "index.html";
    }
}

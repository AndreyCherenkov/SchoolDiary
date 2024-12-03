package ru.andreycherenkov.school.impl;

import ru.andreycherenkov.school.api.GeneralController;

public class GeneralControllerImpl implements GeneralController {

    @Override
    public String getIndex() {
        return "index.html";
    }
}

package ru.andreycherenkov.school.db.entity.enums;

public enum Specialization {

    TECH("технический"),
    HUMANITARIAN("гуманитарный"),
    GENERAL("общеобразовательный");

    final String profile;

    Specialization(String profile) {
        this.profile = profile;
    }
}

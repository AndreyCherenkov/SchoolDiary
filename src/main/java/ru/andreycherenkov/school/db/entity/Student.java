package ru.andreycherenkov.school.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student extends User {

    private String firstName;

    private String lastName;

    private String secondName;

    @ManyToOne(fetch = FetchType.LAZY)
    private SchoolClass schoolClass;
}

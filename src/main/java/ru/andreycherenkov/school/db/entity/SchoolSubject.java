package ru.andreycherenkov.school.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "school_subjects")
public class SchoolSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID subjectId;

    private String title;

    private String homework;

    @OneToOne(mappedBy = "schoolSubject")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private SchoolClass schoolClass;

    @OneToMany(mappedBy = "schoolSubject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Grade> grades;

}

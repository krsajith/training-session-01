package com.unnathy.trainingservice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "course_registration", schema = "training")
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_registration_id_gen")
    @SequenceGenerator(name = "course_registration_id_gen", sequenceName = "course_registration_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "course_name", length = 50)
    private String courseName;

}

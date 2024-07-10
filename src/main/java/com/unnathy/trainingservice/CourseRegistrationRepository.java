package com.unnathy.trainingservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Integer> {
    List<CourseRegistration> findByCourseName(String courseName);
}

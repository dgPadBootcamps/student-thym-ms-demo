package com.dgpad.mvc.repository;

import com.dgpad.mvc.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findCourseByCode(String code);

}
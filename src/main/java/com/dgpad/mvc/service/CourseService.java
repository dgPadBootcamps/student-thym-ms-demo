package com.dgpad.mvc.service;


import com.dgpad.mvc.DTO.request.CreateCourseDTO;
import com.dgpad.mvc.DTO.request.UpdateCourseDTO;
import com.dgpad.mvc.model.Course;
import com.dgpad.mvc.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Method to save a new course
    public Course saveCourse(CreateCourseDTO course) {
        return courseRepository.save(new Course(course.getName(), course.getCode(), course.getInstructor(), course.getCredits()));
    }

    // Method to retrieve all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Method to retrieve a course by its ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // Method to update a course by its ID
    public Course updateCourse(Long id, UpdateCourseDTO updatedCourse) {
        Optional<Course> existingCourseOptional = courseRepository.findById(id);

        if (existingCourseOptional.isPresent()) {
            Course existingCourse = existingCourseOptional.get();
            existingCourse.setName(updatedCourse.getName());
            existingCourse.setInstructor(updatedCourse.getInstructor());
            existingCourse.setCredits(updatedCourse.getCredits());
            return courseRepository.save(existingCourse);
        } else {
            return null; // Course not found
        }
    }

    // Method to delete a course by its ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

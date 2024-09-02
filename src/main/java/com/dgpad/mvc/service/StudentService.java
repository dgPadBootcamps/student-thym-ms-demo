package com.dgpad.mvc.service;


import com.dgpad.mvc.DTO.request.CreateStudentDTO;
import com.dgpad.mvc.DTO.request.UpdateStudentDTO;
import com.dgpad.mvc.model.Course;
import com.dgpad.mvc.model.Student;
import com.dgpad.mvc.repository.CourseRepository;
import com.dgpad.mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student saveStudent(CreateStudentDTO student) {
        return studentRepository.save(new Student(student.getName(),student.getEmail()));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, UpdateStudentDTO updatedStudent) {
        Optional<Student> existingStudentOptional = studentRepository.findById(id);

        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            List<Course> courses = new ArrayList<>();
            for(String courseId : updatedStudent.getCourses()){
                Optional<Course> optionalCourse = courseRepository.findCourseByCode(courseId);
                optionalCourse.ifPresent(courses::add);
            }
            existingStudent.setCourses(courses);
            return studentRepository.save(existingStudent);
        } else {
            return null; // Student not found
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}


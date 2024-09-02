package com.dgpad.mvc.controller;

import com.dgpad.mvc.DTO.request.CreateStudentDTO;
import com.dgpad.mvc.DTO.request.UpdateStudentDTO;
import com.dgpad.mvc.model.Course;
import com.dgpad.mvc.model.Student;
import com.dgpad.mvc.service.CourseService;
import com.dgpad.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students-list";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new CreateStudentDTO());
        return "students-add";
    }

    @PostMapping("/add")
    public String saveStudent(@ModelAttribute("student") CreateStudentDTO student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String updateStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", new UpdateStudentDTO(studentService.getStudentById(id)));
        model.addAttribute("courses", courseService.getAllCourses());
        return "students-update";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") UpdateStudentDTO student) {
        studentService.updateStudent(id,student);
        return "redirect:/students";
    }

}

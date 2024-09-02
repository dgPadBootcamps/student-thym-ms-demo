package com.dgpad.mvc.controller;

import com.dgpad.mvc.DTO.request.CreateCourseDTO;
import com.dgpad.mvc.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses-list";
    }

    @GetMapping("/add")
    public String addCourseForm(Model model) {
        model.addAttribute("course", new CreateCourseDTO());
        return "courses-add";
    }

    @PostMapping("/add")
    public String saveCourse(@Valid @ModelAttribute("course") CreateCourseDTO course,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("course", course);
            return "courses-add"; // Return to the form with validation errors
        }
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

}

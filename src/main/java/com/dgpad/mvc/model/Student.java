package com.dgpad.mvc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Course> courses;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
        this.courses = new ArrayList<>();
    }
}
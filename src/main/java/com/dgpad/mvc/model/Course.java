package com.dgpad.mvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private String instructor;
    private int credits;

    public Course(String name, String code, String instructor, int credits) {
        this.name = name;
        this.code = code;
        this.instructor = instructor;
        this.credits = credits;
    }
}

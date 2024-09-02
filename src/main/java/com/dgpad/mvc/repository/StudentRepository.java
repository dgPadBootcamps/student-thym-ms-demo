package com.dgpad.mvc.repository;

import com.dgpad.mvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

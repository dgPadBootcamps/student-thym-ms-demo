package com.dgpad.mvc.DTO.request;

import com.dgpad.mvc.model.Course;
import com.dgpad.mvc.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentDTO {
    private Long id;
    private String name;
    private String email;
    private List<String> courses;

    public UpdateStudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.courses = student.getCourses().stream().map(Course::getCode).toList();
    }

    @Override
    public String toString() {
        return "UpdateStudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", courses=" + courses +
                '}';
    }
}

package com.dgpad.mvc.DTO.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseDTO {
    @NotBlank(message = "Course name is required")
    @Size(max = 100, message = "Course name should not exceed 100 characters")
    private String name;

    @NotBlank(message = "Course code is required")
    @Size(max = 10, message = "Course code should not exceed 10 characters")
    private String code;

    @NotBlank(message = "Instructor name is required")
    @Size(max = 100, message = "Instructor name should not exceed 100 characters")
    private String instructor;

    @NotNull(message = "Credits are required")
    @Min(value = 1, message = "Credits should be at least 1")
    @Max(value = 4, message = "Credits should not exceed 4")
    private Integer credits;
}

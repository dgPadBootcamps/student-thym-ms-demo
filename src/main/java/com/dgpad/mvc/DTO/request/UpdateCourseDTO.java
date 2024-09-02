package com.dgpad.mvc.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCourseDTO {
    private Long id;
    private String name;
    private String code;
    private String instructor;
    private Integer credits;
}

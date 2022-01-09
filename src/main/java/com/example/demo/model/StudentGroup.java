package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StudentGroup {
    private Long id;
    
    @NotEmpty(message = "The name of the group must be write")
    @Size(min=1, max=30)
    private String nameGroup;

}

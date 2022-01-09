package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Student {
    private Long id;

    @NotEmpty(message = "The name of the student must be write")
    @Size(min=1, max=30)
    private String firstName;

    @NotEmpty(message = "The surname of the student must be write")
    @Size(min=1, max=30)
    private String lastName;

    private String dateOfBirth;

    @Email
    private String email;
    private String phone;

    @NotNull
    private Long groupID;


}

package com.job.searcher.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {


    private Integer id;

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Lastname is required")
    @NotEmpty(message = "Lastname is required")
    private String lastname;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Email not in correct format ")
    private String email;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    private String password;

    private Integer phoneNumber;
}

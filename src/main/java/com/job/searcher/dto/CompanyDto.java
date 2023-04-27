package com.job.searcher.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDto {

    private Integer id ;

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "City is required")
    private String city;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Email not in correct format ")
    private String email;
    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    private String password;


}

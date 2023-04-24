package com.job.searcher.entity;


import com.job.searcher.exceptions.ResourceNotFountException;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Arrays;

@AllArgsConstructor
public enum UserRole {

    ADMIN("ADMIN"),
    USER("USER"),

    COMPANY("COMPANY");


    private String value;

    public static UserRole fromValue(String userRole){
        return Arrays.asList(UserRole.values())
                .stream().filter(r -> r.value.equals(userRole))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFountException(String
                        .format("Role %s not found",userRole)));
    }

    public String getValue() {
        return value;
    }

}

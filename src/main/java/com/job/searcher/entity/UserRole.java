package com.job.searcher.entity;


import com.job.searcher.exceptions.ResourceNotFountException;
import lombok.AllArgsConstructor;
import java.util.Arrays;

@AllArgsConstructor
public enum UserRole {

    ADMIN("ADMIN"),
    USER("USER");

    private String value;

    public static UserRole fromValue(String userRole){
        return Arrays.asList(UserRole.values())
                .stream().filter(role -> role.value.equals(userRole))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFountException(String
                        .format("Role %s not found",userRole)));
    }

    public String getValue() {
        return value;
    }

}

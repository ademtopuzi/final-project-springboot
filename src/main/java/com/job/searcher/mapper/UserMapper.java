package com.job.searcher.mapper;

import com.job.searcher.Dto.UserDto;
import com.job.searcher.Dto.UserUpdateDto;
import com.job.searcher.entity.User;

public class UserMapper {

    public static UserDto toDto (User user){

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();

    }

    public static User toEntity(UserDto u){
        return User.builder()
                .id(u.getId())
                .name(u.getName())
                .lastname(u.getLastname())
                .email(u.getEmail())
                .password(u.getPassword())
                .phoneNumber(u.getPhoneNumber())
                .build();

    }

    public static UserUpdateDto toUserUpdateDto(User  req){
        return UserUpdateDto.builder()
                .id(req.getId())
                .name(req.getName())
                .lastname(req.getLastname())
                .email(req.getEmail())
                .phoneNumber(req.getPhoneNumber())
                .build();
    }

    public static User updateBuilder(User u,UserUpdateDto req){
        u.setName(req.getName());
        u.setLastname(req.getLastname());
        u.setEmail(req.getEmail());
        u.setPhoneNumber(req.getPhoneNumber());
        return u;
    }


}

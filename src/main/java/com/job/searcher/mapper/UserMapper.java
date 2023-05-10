package com.job.searcher.mapper;

import com.job.searcher.dto.UserDto;
import com.job.searcher.dto.UserUpdateDto;
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

    public static User toEntity(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .build();

    }

    public static UserUpdateDto toUserUpdateDto(User  request){
        return UserUpdateDto.builder()
                .id(request.getId())
                .name(request.getName())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public static User updateBuilder(User user,UserUpdateDto request){
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        return user;
    }


}

package com.job.searcher.controller;

import com.job.searcher.dto.UserDto;
import com.job.searcher.dto.UserUpdateDto;
import com.job.searcher.entity.User;
import com.job.searcher.mapper.UserMapper;
import com.job.searcher.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping("/user/")
    public ResponseEntity <UserDto> registerUser (@Validated @RequestBody UserDto request){
        UserDto userDto = userService.registerUser(request,"USER");
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity <UserDto> findUserById(@PathVariable Integer id){
        User user = userService.findUserById(id);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserUpdateDto> updateUser(@PathVariable Integer id,@RequestBody UserUpdateDto request){
        return ResponseEntity.ok(userService.updateUser(id,request));

    }









}

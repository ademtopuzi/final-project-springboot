package com.job.searcher.controller;

import com.job.searcher.Dto.UserDto;
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
    public ResponseEntity <UserDto> registerUser (@Validated @RequestBody UserDto req){
        UserDto dto = userService.registerUser(req,"USER");
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity <UserDto> findUserById(@PathVariable Integer id){
        User u = userService.findUserById(id);
        return ResponseEntity.ok(UserMapper.toDto(u));
    }








}

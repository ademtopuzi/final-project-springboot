package com.job.searcher.service;

import com.job.searcher.dto.UserDto;
import com.job.searcher.dto.UserUpdateDto;
import com.job.searcher.entity.User;

public interface UserService {

    User findUserById (Integer id);

    UserDto registerUser (UserDto req,String userRole);

    UserUpdateDto updateUser(Integer id ,UserUpdateDto req);


}

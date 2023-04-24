package com.job.searcher.service;

import com.job.searcher.Dto.UserDto;
import com.job.searcher.entity.User;

public interface UserService {

    User findUserById (Integer id);

    UserDto registerUser (UserDto req,String userRole);


}

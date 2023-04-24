package com.job.searcher.service.impl;

import com.job.searcher.Dto.UserDto;
import com.job.searcher.entity.User;
import com.job.searcher.entity.UserRole;
import com.job.searcher.exceptions.ResourceNotFountException;
import com.job.searcher.mapper.UserMapper;
import com.job.searcher.repository.UserRepository;
import com.job.searcher.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService , UserDetailsService {



    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFountException(String
                        .format("User with id %s not found " , id )));
    }

    @Override
    public UserDto registerUser(UserDto req, String userRole) {

        User u = UserMapper.toEntity(req);
        u.setRole(userRole!=null?UserRole.fromValue(userRole):UserRole.USER);
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u= userRepository.save(u);

        return UserMapper.toDto(u);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                format("User with username - %s, not found", email)));
    }
}

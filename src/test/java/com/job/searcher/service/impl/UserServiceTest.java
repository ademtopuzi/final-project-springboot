package com.job.searcher.service.impl;

import com.job.searcher.BaseTest;
import com.job.searcher.dto.UserDto;
import com.job.searcher.dto.UserUpdateDto;
import com.job.searcher.entity.User;
import com.job.searcher.exceptions.ResourceNotFountException;
import com.job.searcher.repository.UserRepository;
import com.job.searcher.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService toTest;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void test_findById_ok(){
        Mockito.doReturn(Optional.of(new User())).when(userRepository).findById(Mockito.anyInt());
        User out = toTest.findUserById(1);
        assertNotNull(out);
    }

    @Test
    public void test_findById_ko(){
        Mockito.doThrow(new ResourceNotFountException("User Not Found"))
                .when(userRepository).findById(Mockito.anyInt());
        Throwable throwable=assertThrows(Throwable.class,()->toTest.findUserById(1));
        assertEquals(ResourceNotFountException.class,throwable.getClass());
    }

    @Test
    public void test_registerUser_ok(){
        Mockito.doReturn("annyPassword").when(passwordEncoder).encode(Mockito.anyString());
        Mockito.doReturn(new User()).when(userRepository).save(Mockito.any());
        UserDto out =toTest.registerUser(new UserDto(),"USER");
        assertNotNull(out);

    }

    @Test
    public void test_updateUser_ok(){
        test_findById_ok();
        Mockito.doReturn(new User()).when(userRepository).save(Mockito.any());
        assertNotNull(toTest.updateUser(Mockito.anyInt(),new UserUpdateDto()));

    }


}

package com.job.searcher.controller;

import com.job.searcher.BaseTest;
import com.job.searcher.dto.UserUpdateDto;
import com.job.searcher.entity.User;
import com.job.searcher.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends BaseTest {

    @MockBean
    private UserService userService;

    @Test
    public void test_findUserById_ok()throws Exception{
        Mockito.doReturn(new User()).when(userService).findUserById(Mockito.anyInt());
        mvc.perform(MockMvcRequestBuilders.get("/users/user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void test_updateUser()throws Exception{
        Mockito.doReturn(new UserUpdateDto()).when(userService).updateUser(Mockito.any(),Mockito.any());
        mvc.perform(MockMvcRequestBuilders.put("/users/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(new UserUpdateDto())))
                .andExpect(status().isOk());
    }


}

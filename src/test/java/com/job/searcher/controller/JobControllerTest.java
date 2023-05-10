package com.job.searcher.controller;

import com.job.searcher.BaseTest;
import com.job.searcher.dto.JobCategoryDto;
import com.job.searcher.entity.Job;
import com.job.searcher.service.JobService;
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
public class JobControllerTest extends BaseTest {

    @MockBean
    private  JobService jobService;

    @Test
    public void test_findJobByid_ok()throws Exception{
        Mockito.doReturn(new Job()).when(jobService).findJobByid(Mockito.anyInt());
        mvc.perform(MockMvcRequestBuilders.get("/jobs/job/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void test_addCategory()throws Exception{
        Mockito.doReturn(new JobCategoryDto()).when(jobService).addCategory(Mockito.any());
        mvc.perform(MockMvcRequestBuilders.post("/jobs/category")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new JobCategoryDto())))
                .andExpect(status().isOk());
    }


}

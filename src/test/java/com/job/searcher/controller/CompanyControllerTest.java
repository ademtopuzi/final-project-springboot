package com.job.searcher.controller;

import com.job.searcher.BaseTest;
import com.job.searcher.dto.CompanyUpdateDto;
import com.job.searcher.entity.Company;
import com.job.searcher.service.CompanyService;
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
public class CompanyControllerTest extends BaseTest {

    @MockBean
    private  CompanyService companyService;

    @Test
    public void test_findCompanyById()throws Exception{
        Mockito.doReturn(new Company()).when(companyService).findCompanyById(Mockito.anyInt());
        mvc.perform(MockMvcRequestBuilders.get("/companies/company/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void test_updateCompany()throws Exception{
        Mockito.doReturn(new CompanyUpdateDto()).when(companyService).updateCompany(Mockito.anyInt(),Mockito.any());
        mvc.perform(MockMvcRequestBuilders.put("/companies/company/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new CompanyUpdateDto())))
                .andExpect(status().isOk());
    }

}

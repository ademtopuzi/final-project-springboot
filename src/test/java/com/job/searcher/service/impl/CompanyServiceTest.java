package com.job.searcher.service.impl;

import com.job.searcher.BaseTest;
import com.job.searcher.dto.CompanyDto;
import com.job.searcher.entity.Company;
import com.job.searcher.exceptions.ResourceNotFountException;
import com.job.searcher.repository.CompanyRepository;
import com.job.searcher.service.CompanyService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@SpringBootTest
public class CompanyServiceTest extends BaseTest {

    @Autowired
    private CompanyService toTest;

    @MockBean
    private CompanyRepository companyRepository;
    @MockBean
    private  PasswordEncoder passwordEncoder;

    @Test
    public void test_registerCompany(){
        Mockito.doReturn("any password").when(passwordEncoder).encode(Mockito.anyString());
        Mockito.doReturn(new Company()).when(companyRepository).save(Mockito.any());
        CompanyDto out = toTest.registerCompany(new CompanyDto());
        assertNotNull(out);
    }

    @Test
    public void test_findCompanyById_ok(){
        Mockito.doReturn(Optional.of(new Company())).when(companyRepository).findById(Mockito.anyInt());
        Company out = toTest.findCompanyById(1);
        assertNotNull(out);
    }

    @Test
    public void test_findCompanyById_ko(){
        Mockito.doThrow(new ResourceNotFountException("Company not found")).when(companyRepository).findById(Mockito.anyInt());
        Throwable throwable=assertThrows(Throwable.class,()->toTest.findCompanyById(1));
        assertEquals(ResourceNotFountException.class,throwable.getClass());
    }

}

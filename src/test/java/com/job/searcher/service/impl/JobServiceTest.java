package com.job.searcher.service.impl;

import com.job.searcher.BaseTest;
import com.job.searcher.dto.JobCategoryDto;
import com.job.searcher.dto.JobDto;
import com.job.searcher.entity.Category;
import com.job.searcher.entity.Company;
import com.job.searcher.entity.Job;
import com.job.searcher.exceptions.ResourceNotFountException;
import com.job.searcher.repository.CategoryRepository;
import com.job.searcher.repository.CompanyRepository;
import com.job.searcher.repository.JobRepository;
import com.job.searcher.service.JobService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JobServiceTest extends BaseTest {

    @Autowired
    private JobService toTest;
    @MockBean
    private  JobRepository jobRepository;
    @MockBean
    private  CategoryRepository categoryRepository;
    @MockBean
    private CompanyRepository companyRepository;

    @Test
    public void test_findJobById_ok(){

        Mockito.doReturn(Optional.of(new Job())).when(jobRepository).findById(Mockito.anyInt());
        Job out= toTest.findJobByid(1);
        assertNotNull(out);
    }

    @Test
    public void test_findJobById_ko(){
        Mockito.doThrow(new ResourceNotFountException("Job not found"))
                .when(jobRepository).findById(Mockito.anyInt());
        Throwable throwable=assertThrows(Throwable.class,()->toTest.findJobByid(1));
        assertEquals(ResourceNotFountException.class,throwable.getClass());
    }

    @Test
    public void test_addCategory_ok(){
        Mockito.doReturn(new Category()).when(categoryRepository).save(Mockito.any());
        JobCategoryDto out=toTest.addCategory(new JobCategoryDto());
        assertNotNull(out);
    }

    @Test
    public void test_findJobsByCompanyId(){
        List<Job> fakeJobs=new ArrayList<>();
        Job job1=new Job();
        job1.setId(1);
        Job job2=new Job();
        job2.setId(2);
        fakeJobs.add(job1);
        fakeJobs.add(job2);
        Mockito.doReturn(fakeJobs).when(jobRepository).findJobsByCompanyId(Mockito.anyInt());
        List<JobDto> out= toTest.findJobsByCompanyId(1);
        assertEquals(2,out.size());
    }

    @Test
    public void test_findJobsByCategoryId(){
        List<Job> fakeJobs=new ArrayList<>();
        Job job1=new Job();
        job1.setId(1);
        Job job2=new Job();
        job2.setId(2);
        fakeJobs.add(job1);
        fakeJobs.add(job2);
        Mockito.doReturn(fakeJobs).when(jobRepository).findJobsByCategoryId(Mockito.anyInt());
        List<JobDto> out= toTest.findJobsByCategoryId(1);
        assertEquals(2,out.size());
    }

}

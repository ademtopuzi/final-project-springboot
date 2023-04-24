package com.job.searcher.service;

import com.job.searcher.Dto.JobCategoryDto;
import com.job.searcher.Dto.JobDto;
import com.job.searcher.entity.Job;

import java.util.List;

public interface JobService {

    JobDto addJob(Integer categoryId ,JobDto req,Integer companyId);

    Job findJobByid(Integer id);

    JobCategoryDto addCategory(JobCategoryDto req);

    List<JobDto> findJobsByCompanyId(Integer companyId);

    List<JobDto> findJobsByCategoryId(Integer categoryId);


}

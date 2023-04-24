package com.job.searcher.repository.custom;

import com.job.searcher.entity.Job;

import java.util.List;

public interface JobRepositoryCustom {


    List<Job> findJobsByCompanyId(Integer companyId);

    List<Job> findJobsByCategoryId(Integer categoryId);
}

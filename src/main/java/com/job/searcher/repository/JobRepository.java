package com.job.searcher.repository;

import com.job.searcher.entity.Job;

import com.job.searcher.repository.custom.JobRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface JobRepository extends JpaRepository<Job, Integer>, JobRepositoryCustom {

    @Query(name="job_findByJobByCompany")
    List<Job> findJobsByCompanyId(Integer company_id);

    @Query(name="job_findByJobByCategory")
    List<Job> findJobsByCategoryId(Integer category_id);



}

package com.job.searcher.repository;

import com.job.searcher.entity.Applied;

import com.job.searcher.repository.custom.AppliedReposirotyCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppliedREpository extends JpaRepository<Applied,Integer> , AppliedReposirotyCustom {

    @Query(name="applied_findByAppliedByUser")
    List<Applied> findAppliedByUserId(Integer user_id);

    @Query(name = "applied_findByAppliedByJob")
    List<Applied> findAppliedByJobId(Integer job_id);

}

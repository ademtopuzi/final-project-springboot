package com.job.searcher.repository.custom;

import com.job.searcher.entity.Applied;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class AppliedReposirotyCustomimpl implements AppliedReposirotyCustom{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Applied> findAppliedByUserId(Integer userId) {


        return entityManager.createNamedQuery("applied_findByAppliedByUser",Applied.class)
                .setParameter("user_id",userId)
                .getResultList();
    }

    @Override
    public List<Applied> findAppliedByJobId(Integer jobId) {
        return entityManager.createNamedQuery("applied_findByAppliedByJob",Applied.class)
                .setParameter("job_id",jobId)
                .getResultList();
    }
}

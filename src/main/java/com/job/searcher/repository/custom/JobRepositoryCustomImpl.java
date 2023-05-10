package com.job.searcher.repository.custom;

import com.job.searcher.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class JobRepositoryCustomImpl implements JobRepositoryCustom {


    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Job> findJobsByCompanyId(Integer companyId) {

        return entityManager.createNamedQuery("job_findByJobByCompany",Job.class)
                .setParameter("company_id",companyId)
                .getResultList();
    }

    @Override
    public List<Job> findJobsByCategoryId(Integer categoryId) {
        return entityManager.createNamedQuery("job_findByJobByCategory",Job.class)
                .setParameter("category_id",categoryId)
                .getResultList();
    }
}

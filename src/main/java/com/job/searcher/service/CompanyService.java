package com.job.searcher.service;

import com.job.searcher.Dto.CompanyDto;
import com.job.searcher.Dto.CompanyUpdateDto;
import com.job.searcher.Dto.JobDto;
import com.job.searcher.entity.Company;

import javax.persistence.criteria.CriteriaBuilder;

public interface CompanyService {

    CompanyDto registerCompany(CompanyDto req);
    Company findCompanyById (Integer id);

    CompanyUpdateDto updateCompany(Integer id , CompanyUpdateDto req);








}

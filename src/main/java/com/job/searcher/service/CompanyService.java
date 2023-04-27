package com.job.searcher.service;

import com.job.searcher.dto.CompanyDto;
import com.job.searcher.dto.CompanyUpdateDto;
import com.job.searcher.entity.Company;

public interface CompanyService {

    CompanyDto registerCompany(CompanyDto req);
    Company findCompanyById (Integer id);

    CompanyUpdateDto updateCompany(Integer id , CompanyUpdateDto req);








}

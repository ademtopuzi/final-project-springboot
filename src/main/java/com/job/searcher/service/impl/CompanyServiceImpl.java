package com.job.searcher.service.impl;

import com.job.searcher.dto.CompanyDto;
import com.job.searcher.dto.CompanyUpdateDto;
import com.job.searcher.entity.Company;
import com.job.searcher.exceptions.ResourceNotFountException;
import com.job.searcher.mapper.CompanyMapper;
import com.job.searcher.repository.CompanyRepository;
import com.job.searcher.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public CompanyDto registerCompany(CompanyDto request) {

        Company company = CompanyMapper.toEntity(request);
        company.setPassword(passwordEncoder.encode(request.getPassword()));
        company=companyRepository.save(company);
        return CompanyMapper.toDto(company);
    }

    @Override
    public Company findCompanyById(Integer id) {
        return companyRepository.findById(id).orElseThrow(() ->new ResourceNotFountException(String
                .format("Company with id %s not found " , id )));
    }

    @Override
    public CompanyUpdateDto updateCompany(Integer id, CompanyUpdateDto request) {

        Company company =findCompanyById(id);
        company=CompanyMapper.updateBuilder(company,request);

        return CompanyMapper.companyUpdateDto(companyRepository.save(company));
    }


}

package com.job.searcher.service.impl;

import com.job.searcher.Dto.CompanyDto;
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

    private final CompanyRepository cm;
    private final PasswordEncoder passwordEncoder;


    @Override
    public CompanyDto registerCompany(CompanyDto req) {

        Company c = CompanyMapper.toEntity(req);
        c.setPassword(passwordEncoder.encode(req.getPassword()));
        c=cm.save(c);
        return CompanyMapper.toDto(c);
    }

    @Override
    public Company findCompanyById(Integer id) {
        return cm.findById(id).orElseThrow(() ->new ResourceNotFountException(String
                .format("Company with id %s not found " , id )));
    }


}

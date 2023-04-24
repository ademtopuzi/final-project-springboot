package com.job.searcher.mapper;

import com.job.searcher.Dto.CompanyDto;
import com.job.searcher.Dto.JobDto;
import com.job.searcher.entity.Company;
import com.job.searcher.entity.Job;

import java.util.stream.Collectors;

public class CompanyMapper {

    public static CompanyDto toDto (Company company){

        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .city(company.getCity())
                .email(company.getEmail())
                .password(company.getPassword())
                .build();

    }



    public static Company toEntity(CompanyDto cm){
        return Company.builder()
                .name(cm.getName())
                .city(cm.getCity())
                .email(cm.getEmail())
                .password(cm.getPassword())
                .build();
    }

}
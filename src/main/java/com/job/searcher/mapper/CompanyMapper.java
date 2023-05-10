package com.job.searcher.mapper;

import com.job.searcher.dto.CompanyDto;
import com.job.searcher.dto.CompanyUpdateDto;
import com.job.searcher.entity.Company;

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



    public static Company toEntity(CompanyDto companyDto){
        return Company.builder()
                .name(companyDto.getName())
                .city(companyDto.getCity())
                .email(companyDto.getEmail())
                .password(companyDto.getPassword())
                .build();
    }

    public static CompanyUpdateDto companyUpdateDto(Company company){
        return CompanyUpdateDto.builder()
                .id(company.getId())
                .name(company.getName())
                .city(company.getCity())
                .email(company.getEmail())
                .build();
    }

    public static Company updateBuilder(Company company,CompanyUpdateDto updateDto){
        company.setName(updateDto.getName());
        company.setEmail(updateDto.getEmail());
        company.setCity(updateDto.getCity());
        return company;
    }

}

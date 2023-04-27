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



    public static Company toEntity(CompanyDto cm){
        return Company.builder()
                .name(cm.getName())
                .city(cm.getCity())
                .email(cm.getEmail())
                .password(cm.getPassword())
                .build();
    }

    public static CompanyUpdateDto companyUpdateDto(Company c){
        return CompanyUpdateDto.builder()
                .id(c.getId())
                .name(c.getName())
                .city(c.getCity())
                .email(c.getEmail())
                .build();
    }

    public static Company updateBuilder(Company c,CompanyUpdateDto updateDto){
        c.setName(updateDto.getName());
        c.setEmail(updateDto.getEmail());
        c.setCity(updateDto.getCity());
        return c;
    }

}

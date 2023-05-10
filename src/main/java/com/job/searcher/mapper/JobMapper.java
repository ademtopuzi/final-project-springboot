package com.job.searcher.mapper;

import com.job.searcher.dto.JobCategoryDto;
import com.job.searcher.dto.JobDto;
import com.job.searcher.entity.Category;
import com.job.searcher.entity.Company;
import com.job.searcher.entity.Job;

public class JobMapper {



    public static JobDto toDto(Job job){
        return JobDto.builder()
                .position(job.getPosition())
                .salary(job.getSalary())
                .experience(job.getExperience())
                .requirements(job.getRequirements())
                .jobCategoryDto(job.getCategory()!=null?toDto(job.getCategory()):null)
                .companyDto(job.getCompany()!=null?CompanyMapper.toDto(job.getCompany()):null )
                .build();
    }

    public static Job toEntity(JobDto jobDto, Category category, Company company){
        return Job.builder()
                .position(jobDto.getPosition())
                .salary(jobDto.getSalary())
                .experience(jobDto.getExperience())
                .requirements(jobDto.getRequirements())
                .category(category)
                .company(company)
                .build();
    }

    public static JobCategoryDto toDto(Category category){
        return JobCategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .parentCategory(category.getParent()!=null?JobMapper.toDto(category.getParent()):null)
                .build();

    }

    public static Category toEntity(JobCategoryDto categoryDto){
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();

    }

}

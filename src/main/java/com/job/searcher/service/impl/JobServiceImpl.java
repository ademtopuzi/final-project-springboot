package com.job.searcher.service.impl;

import com.job.searcher.dto.JobCategoryDto;
import com.job.searcher.dto.JobDto;
import com.job.searcher.entity.Category;
import com.job.searcher.entity.Company;
import com.job.searcher.entity.Job;
import com.job.searcher.exceptions.ResourceNotFountException;
import com.job.searcher.mapper.JobMapper;
import com.job.searcher.repository.CategoryRepository;
import com.job.searcher.repository.CompanyRepository;
import com.job.searcher.repository.JobRepository;
import com.job.searcher.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final CategoryRepository categoryRepository;

    private final CompanyRepository companyRepository;



    @Override
    public JobDto addJob(Integer categoryId, JobDto request, Integer companyId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFountException(String.format("Category with id %s not found ",categoryId)));

        Company company =companyRepository.findById(companyId)
                .orElseThrow(()->new ResourceNotFountException(String.format("Company with id %s not found ",companyId)));
        Job job = JobMapper.toEntity(request,category,company);
        job= jobRepository.save(job);
        return JobMapper.toDto(job);
    }

    @Override
    public Job findJobByid(Integer id) {

        return jobRepository.findById(id)
                .orElseThrow(()->new ResourceNotFountException(String.format("Job with id %s  not found ",id)));
    }

    @Override
    public JobCategoryDto addCategory(JobCategoryDto request) {

        Category save = JobMapper.toEntity(request);
        if(request.getParentCategory()!=null){
            save.setParent(categoryRepository.findById(request.getParentCategory().getId())
                    .orElseThrow(()->new ResourceNotFountException(String
                            .format("Parent category with id %s not found ",request.getParentCategory().getId()))));

        }

        return JobMapper.toDto(categoryRepository.save(save));
    }

    @Override
    public List<JobDto> findJobsByCompanyId(Integer companyId) {


        return jobRepository.findJobsByCompanyId(companyId)
                .stream().map(JobMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<JobDto> findJobsByCategoryId(Integer categoryId) {
        return jobRepository.findJobsByCategoryId(categoryId)
                .stream().map(JobMapper::toDto)
                .collect(Collectors.toList());
    }
}

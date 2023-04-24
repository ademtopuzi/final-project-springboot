package com.job.searcher.controller;


import com.job.searcher.Dto.JobCategoryDto;
import com.job.searcher.Dto.JobDto;
import com.job.searcher.entity.Job;
import com.job.searcher.mapper.JobMapper;
import com.job.searcher.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")
@Validated
public class JobController {

    private final JobService jobService;

    @PostMapping("/job/{categoryID}/{companyID}")
    public ResponseEntity<JobDto> addJob(@PathVariable Integer categoryID ,@PathVariable Integer companyID,@Validated@RequestBody JobDto req){
        JobDto jobDto= jobService.addJob(categoryID,req,companyID);
        return ResponseEntity.ok(jobDto);

    }

    @GetMapping("/job/{id}")
    public ResponseEntity<JobDto> findJobByid(@PathVariable Integer id ){
        Job job = jobService.findJobByid(id);
        return ResponseEntity.ok(JobMapper.toDto(job));
    }

    @PostMapping("/category")
    public ResponseEntity<JobCategoryDto> addCategory(@RequestBody JobCategoryDto req){

        return ResponseEntity.ok(jobService.addCategory(req));
    }

    @GetMapping("/company/{companyId}/list")
    public ResponseEntity<List<JobDto>> getJobsByCompanyId(@PathVariable Integer companyId){
        return ResponseEntity.ok(jobService.findJobsByCompanyId(companyId));
    }

    @GetMapping("/category/{categoryId}/list")
    public ResponseEntity<List<JobDto>> getJobsByCategoryId(@PathVariable Integer categoryId){
        return ResponseEntity.ok(jobService.findJobsByCategoryId(categoryId));
    }
}

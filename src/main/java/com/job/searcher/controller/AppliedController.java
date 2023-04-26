package com.job.searcher.controller;

import com.job.searcher.Dto.AppliedDto;
import com.job.searcher.service.AppliedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apply")
@Validated
public class AppliedController {

    private final AppliedService service;

    @PostMapping("/apply/{userId}/{jobId}")
    public ResponseEntity<AppliedDto> addAplication(@PathVariable Integer userId,@PathVariable Integer jobId ){
        return ResponseEntity.ok(service.addAplication(userId,jobId));
    }

    @GetMapping("/applied/{userId}/list")
    public ResponseEntity<List<AppliedDto>> findApplicationsByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(service.jobsAppliedByUserId(userId));
    }
    @GetMapping("/applied/{jobId}/joblist")
    public ResponseEntity<List<AppliedDto>> findApplicationsByJobId(@PathVariable Integer jobId){
        return ResponseEntity.ok(service.jobsAppliedByJobId(jobId));
    }
}

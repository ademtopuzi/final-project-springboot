package com.job.searcher.service;

import com.job.searcher.dto.AppliedDto;


import java.util.List;

public interface AppliedService {

    AppliedDto addAplication(Integer userId,Integer jobId);
    List<AppliedDto> jobsAppliedByUserId(Integer userId);

    List<AppliedDto> jobsAppliedByJobId(Integer jobId);
}

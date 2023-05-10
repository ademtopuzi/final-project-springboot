package com.job.searcher.service.impl;

import com.job.searcher.dto.AppliedDto;
import com.job.searcher.entity.Applied;
import com.job.searcher.entity.Job;
import com.job.searcher.entity.User;
import com.job.searcher.exceptions.ResourceNotFountException;
import com.job.searcher.mapper.AppliedMapper;
import com.job.searcher.repository.AppliedREpository;
import com.job.searcher.repository.JobRepository;
import com.job.searcher.repository.UserRepository;
import com.job.searcher.service.AppliedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppliedServiceImpl implements AppliedService {

    private final AppliedREpository appliedREpository;

    private final UserRepository userRepository;

    private final JobRepository jobRepository;


    @Override
    public AppliedDto addAplication(Integer userId, Integer jobId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFountException(String.format("User with id %s not found ",userId)));
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()->new ResourceNotFountException(String.format("Job with id %s not found ",jobId)));


        Applied applied = AppliedMapper.toEntity(user,job);
        applied=appliedREpository.save(applied);


        return AppliedMapper.toDTo(applied);
    }

    @Override
    public List<AppliedDto> jobsAppliedByUserId(Integer userId) {

        return appliedREpository.findAppliedByUserId(userId)
                .stream().map(AppliedMapper::toDTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppliedDto> jobsAppliedByJobId(Integer jobId) {
        return appliedREpository.findAppliedByJobId(jobId)
                .stream().map(AppliedMapper::toDTo)
                .collect(Collectors.toList());
    }
}

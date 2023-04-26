package com.job.searcher.repository.custom;

import com.job.searcher.entity.Applied;

import java.util.List;

public interface AppliedReposirotyCustom {

    List<Applied> findAppliedByUserId(Integer userId);

    List<Applied> findAppliedByJobId(Integer jobId);
}

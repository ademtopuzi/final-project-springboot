package com.job.searcher.mapper;

import com.job.searcher.dto.AppliedDto;
import com.job.searcher.entity.Applied;
import com.job.searcher.entity.Job;
import com.job.searcher.entity.User;

public class AppliedMapper {


    public static AppliedDto toDTo(Applied applied){
        return AppliedDto.builder()
                .id(applied.getId())
                .jobDto(applied.getJob()!=null?JobMapper.toDto(applied.getJob()):null)
                .userDto(applied.getUser()!=null?UserMapper.toDto(applied.getUser()):null)
                .build();

    }

    public static Applied toEntity( User user , Job job){
        return Applied.builder()
                .job(job)
                .user(user)
                .build();
    }

}

package com.job.searcher.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDto {

    private Integer id ;

    @NotNull(message = "Position is required")
    private String position;

    private Integer salary;

    private Integer experience;

    private String requirements;

    private CompanyDto companyDto;

    private JobCategoryDto jobCategoryDto;



}

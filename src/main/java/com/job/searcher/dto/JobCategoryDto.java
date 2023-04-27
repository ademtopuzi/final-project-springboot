package com.job.searcher.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JobCategoryDto {

    private Integer id ;

    @NotNull(message = "Name is required")
    private String name;

    private JobCategoryDto parentCategory;

}

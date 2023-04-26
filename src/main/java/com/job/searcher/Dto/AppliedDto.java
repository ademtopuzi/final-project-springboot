package com.job.searcher.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppliedDto {

    private Integer id;

    private JobDto jobDto;

    private UserDto userDto;
}

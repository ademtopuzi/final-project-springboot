package com.job.searcher.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name ="job")
public class Job {

    @Id
    @GeneratedValue
    private Integer id ;

    private String position;

    private Integer salary;

    private Integer experience;

    private String requirements;


    @ManyToOne
    @JoinColumn(name="company_id",referencedColumnName = "id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "job",fetch = FetchType.LAZY)
    private List<Applied> jobsApplied;


}

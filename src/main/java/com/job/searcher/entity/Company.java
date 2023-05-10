package com.job.searcher.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Table(name ="company")
public class Company {

    @Id
    @GeneratedValue
    private Integer id ;

    private String name;
    private String city;
    @Column(unique = true)
    private String email;
    private String password;

    @CreatedDate
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private List<Job>jobs;

}

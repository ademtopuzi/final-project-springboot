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

@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_categories")
@Builder
@Data
public class Category {

    @Id
    @GeneratedValue
    private Integer id ;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    private Category parent;

    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Category> subCategories;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Job> jobs;

    @CreatedDate
    private LocalDateTime createdAt;


}

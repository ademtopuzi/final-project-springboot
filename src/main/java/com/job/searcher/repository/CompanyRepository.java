package com.job.searcher.repository;

import com.job.searcher.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;




@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {




}

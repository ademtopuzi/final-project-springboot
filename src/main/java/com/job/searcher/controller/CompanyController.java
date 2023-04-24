package com.job.searcher.controller;


import com.job.searcher.Dto.CompanyDto;
import com.job.searcher.entity.Company;
import com.job.searcher.mapper.CompanyMapper;
import com.job.searcher.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/companies")
@Validated
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/company/")
    public ResponseEntity<CompanyDto> registerCompany(@Validated @RequestBody CompanyDto req){
        CompanyDto companyDto = companyService.registerCompany(req);
        return ResponseEntity.ok(companyDto);

    }

    @GetMapping("/company/{id}")
    public ResponseEntity<CompanyDto> findCompanyById(@PathVariable Integer id ){
        Company c = companyService.findCompanyById(id);
        return ResponseEntity.ok(CompanyMapper.toDto(c));
    }
}

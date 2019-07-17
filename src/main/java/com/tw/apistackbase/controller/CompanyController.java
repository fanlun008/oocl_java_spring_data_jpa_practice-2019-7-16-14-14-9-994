package com.tw.apistackbase.controller;

import com.tw.apistackbase.core.Company;
import com.tw.apistackbase.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    CompanyRepo companyRepo;

    @GetMapping("/companies")
    public List<Company> getAll() {
        List<Company> all = companyRepo.findAll();
        return all;
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company) {
        Company company1 = companyRepo.saveAndFlush(company);
        System.out.println(company1);
    }

}

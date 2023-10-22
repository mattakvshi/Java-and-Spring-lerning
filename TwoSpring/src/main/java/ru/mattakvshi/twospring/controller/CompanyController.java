package ru.mattakvshi.twospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mattakvshi.twospring.company.ITCompany;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    ITCompany company;

    @GetMapping
    public ITCompany getCompany(){
        return company;
    }
}

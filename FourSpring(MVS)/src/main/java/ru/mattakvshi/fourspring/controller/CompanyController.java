package ru.mattakvshi.fourspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mattakvshi.fourspring.company.ITCompany;
import ru.mattakvshi.fourspring.company.employer.Developer;
import ru.mattakvshi.fourspring.company.employer.Employer;
import ru.mattakvshi.fourspring.company.employer.ITRole;
import ru.mattakvshi.fourspring.company.employer.PM;
import ru.mattakvshi.fourspring.dto.CompanyDTO;
import ru.mattakvshi.fourspring.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;


    @GetMapping
    public CompanyDTO company(){
        return CompanyDTO.from(companyService.getCompany());
    }

    @PostMapping("/employers/developers")
    public ResponseEntity addEmployer(@RequestBody Developer developer) {
        log.info("add developer");
        companyService.addDeveloper(developer);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/employers/PMs")
    public ResponseEntity addEmployer(@RequestBody PM pm) {
        companyService.addPM(pm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employers/{index}")
    public ResponseEntity<Employer<ITRole>> getEmployerByIndex(@PathVariable int index) {
        log.info("get employer by index = " + index);
        try {
            return ResponseEntity.ok(companyService.getEmployerByIndex(index));
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employers/find")
    public ResponseEntity<List<Employer<ITRole>>> getEmployerByRole(@RequestParam ( name = "role") ITRole role ){
        log.info("get employer by role = " + role);
        return ResponseEntity.ok(companyService.getEmployerByRole(role));
    }

}

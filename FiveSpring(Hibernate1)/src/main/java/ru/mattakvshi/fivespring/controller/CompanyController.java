package ru.mattakvshi.fivespring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mattakvshi.fivespring.company.employer.Developer;
import ru.mattakvshi.fivespring.company.employer.Employer;
import ru.mattakvshi.fivespring.company.employer.ITRole;
import ru.mattakvshi.fivespring.company.employer.PM;
import ru.mattakvshi.fivespring.dto.CompanyDTO;
import ru.mattakvshi.fivespring.service.CompanyService;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;


    @GetMapping
    public CompanyDTO company(){
        log.info("get company info");
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
        log.info("add PM");
        companyService.addPM(pm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employers/{index}")
    public ResponseEntity<Employer<ITRole>> getEmployerByIndex(@PathVariable int index) {
        log.info("get employer by index = " + index);
        try {
            if (companyService.getEmployerByIndex(index) != null)
                return ResponseEntity.ok(companyService.getEmployerByIndex(index));
            else return ResponseEntity.notFound().build();
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

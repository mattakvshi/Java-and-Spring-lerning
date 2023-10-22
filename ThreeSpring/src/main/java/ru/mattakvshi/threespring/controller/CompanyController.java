package ru.mattakvshi.threespring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mattakvshi.threespring.company.ITCompany;
import ru.mattakvshi.threespring.company.employer.Developer;
import ru.mattakvshi.threespring.company.employer.Employer;
import ru.mattakvshi.threespring.company.employer.ITRole;
import ru.mattakvshi.threespring.company.employer.PM;
import ru.mattakvshi.threespring.dto.CompanyDTO;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    //@Qualifier("RequestScopedCompany")
    private ITCompany company;

    @GetMapping
    public CompanyDTO company(){

        return CompanyDTO.from(company);
    }

    @PostMapping("/employers/developers")
    public ResponseEntity addEmployer(@RequestBody Developer developer) {
        log.info("add developer");
        company.getEntities().add(developer);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/employers/PMs")
    public ResponseEntity addEmployer(@RequestBody PM pm) {
        company.getEntities().add(pm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employers/{index}")
    public ResponseEntity<Employer<ITRole>> getEmployerByIndex(@PathVariable int index) {
        log.info("get employer by index = " + index);
        try {
            Employer<ITRole> employer = company.getEntities().get(index);
            return ResponseEntity.ok(employer);
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employers/find")
    public ResponseEntity<List<Employer<ITRole>>> getEmployerByRole(@RequestParam ( name = "role") ITRole role ){
        log.info("get employer by role = " + role);
        List<Employer<ITRole>> employers = company.getEntities().stream()
                .filter(employer -> employer.getRole().equals(role))
                .collect(Collectors.toList());
        return ResponseEntity.ok(employers);
    }

}

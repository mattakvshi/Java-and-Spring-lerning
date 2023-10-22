package ru.mattakvshi.sixspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mattakvshi.sixspring.company.employee.Developer;
import ru.mattakvshi.sixspring.company.employee.Employee;
import ru.mattakvshi.sixspring.company.employee.ITRole;
import ru.mattakvshi.sixspring.company.employee.PM;
import ru.mattakvshi.sixspring.dto.CompanyDTO;
import ru.mattakvshi.sixspring.dto.ITEmployeeDTO;
import ru.mattakvshi.sixspring.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Integer createCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.createCompany(companyDTO.toCompany());
    }

    @GetMapping("/{id}")
    public CompanyDTO company(@PathVariable int id){
        log.info("get company info");
        return CompanyDTO.from(companyService.getCompany(id));
    }

    @PostMapping("/{id}/employers/developers")
    public ResponseEntity addEmployer(@RequestBody Developer developer, @PathVariable(name = "id") int company_id) {
        log.info("add developer");
        companyService.addDeveloper(developer, company_id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/employers/PMs")
    public ResponseEntity addEmployer(@RequestBody PM pm, @PathVariable(name = "id") int company_id) {
        log.info("add PM");
        companyService.addPM(pm, company_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employers/{index}")
    public ResponseEntity<Employee<ITRole>> getEmployerByIndex(@PathVariable int index) {
        log.info("get employer by index = " + index);
        try {
            if (companyService.getEmployerByIndex(index) != null)
                return ResponseEntity.ok(companyService.getEmployerByIndex(index));
            else return ResponseEntity.notFound().build();
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/employers/role/find")
    public ResponseEntity<List<ITEmployeeDTO>> getEmployerByRole(
            @RequestParam ( name = "role") ITRole role,
            @PathVariable(name = "id") int company_id){
        log.info("get employer by role = " + role);

        List<ITEmployeeDTO> result = companyService.getEmployerByRole(role, company_id)
                .stream()
                .map(ITEmployeeDTO::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}/employers/age/find")
    public ResponseEntity<List<ITEmployeeDTO>> getEmployerByAge(
            @RequestParam ( name = "age") int age,
            @PathVariable(name = "id") int company_id){
        log.info("get employer by role = " + age);

        List<ITEmployeeDTO> result = companyService.getEmployerByAge(age, company_id)
                .stream()
                .map(ITEmployeeDTO::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

}

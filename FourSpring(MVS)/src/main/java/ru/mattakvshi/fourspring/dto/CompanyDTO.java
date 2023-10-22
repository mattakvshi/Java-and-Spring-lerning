package ru.mattakvshi.fourspring.dto;
import lombok.Data;
import ru.mattakvshi.fourspring.company.ITCompany;
import ru.mattakvshi.fourspring.company.employer.Employer;
import ru.mattakvshi.fourspring.company.employer.ITRole;

import java.util.List;

@Data
public class CompanyDTO {
    private String name;
    private Employer<ITRole> director;
    private List<Employer<ITRole>> employers;

    public static CompanyDTO from(ITCompany company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setDirector(company.getDirector());
        companyDTO.setName(company.getName());
        companyDTO.setEmployers(company.getEntities());
        return companyDTO;
    }
}

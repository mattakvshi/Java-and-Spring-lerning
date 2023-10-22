package ru.mattakvshi.threespring.dto;
import lombok.Data;
import ru.mattakvshi.threespring.company.ITCompany;
import ru.mattakvshi.threespring.company.employer.Employer;
import ru.mattakvshi.threespring.company.employer.ITRole;

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

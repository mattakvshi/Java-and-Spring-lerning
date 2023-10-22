package ru.mattakvshi.fourspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.mattakvshi.fourspring.company.ITCompany;
import ru.mattakvshi.fourspring.company.employer.Developer;
import ru.mattakvshi.fourspring.company.employer.Employer;
import ru.mattakvshi.fourspring.company.employer.ITRole;
import ru.mattakvshi.fourspring.company.employer.PM;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    @Qualifier("RequestScopedCompany")
    private ITCompany company;

    @Override
    public ITCompany getCompany() {
        return company;
    }

    @Override
    public void addDeveloper(Developer developer) {
        company.getEntities().add(developer);

    }

    @Override
    public void addPM(PM pm) {
        company.getEntities().add(pm);
    }

    @Override
    public Employer<ITRole> getEmployerByIndex(int index) {
        Employer<ITRole> employer = company.getEntities().get(index);
        return employer;
    }

    @Override
    public List<Employer<ITRole>> getEmployerByRole(ITRole role) {
        List<Employer<ITRole>> employers = company.getEntities().stream()
                .filter(employer -> employer.getRole().equals(role))
                .collect(Collectors.toList());
        return employers;
    }
}

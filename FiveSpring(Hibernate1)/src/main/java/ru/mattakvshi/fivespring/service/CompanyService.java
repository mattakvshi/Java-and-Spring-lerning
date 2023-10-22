package ru.mattakvshi.fivespring.service;

import ru.mattakvshi.fivespring.company.ITCompany;
import ru.mattakvshi.fivespring.company.employer.Developer;
import ru.mattakvshi.fivespring.company.employer.Employer;
import ru.mattakvshi.fivespring.company.employer.ITRole;
import ru.mattakvshi.fivespring.company.employer.PM;

import java.util.List;

public interface CompanyService {
    ITCompany getCompany();
    void addDeveloper(Developer developer);
    void addPM(PM pm);
    Employer<ITRole> getEmployerByIndex(int index);
    List<Employer<ITRole>> getEmployerByRole(ITRole role);
}

package ru.mattakvshi.fourspring.service;

import ru.mattakvshi.fourspring.company.ITCompany;
import ru.mattakvshi.fourspring.company.employer.Developer;
import ru.mattakvshi.fourspring.company.employer.Employer;
import ru.mattakvshi.fourspring.company.employer.ITRole;
import ru.mattakvshi.fourspring.company.employer.PM;

import java.util.List;

public interface CompanyService {
    ITCompany getCompany();
    void addDeveloper(Developer developer);
    void addPM(PM pm);
    Employer<ITRole> getEmployerByIndex(int index);
    List<Employer<ITRole>> getEmployerByRole(ITRole role);
}

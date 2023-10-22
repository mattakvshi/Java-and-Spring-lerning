package ru.mattakvshi.fivespring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.mattakvshi.fivespring.company.ITCompany;
import ru.mattakvshi.fivespring.company.employer.Developer;
import ru.mattakvshi.fivespring.company.employer.Employer;
import ru.mattakvshi.fivespring.company.employer.ITRole;
import ru.mattakvshi.fivespring.company.employer.PM;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
//    @Qualifier("RequestScopedCompany")
    private ITCompany company;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ITCompany getCompany() {
        return company;
    }

    @Override
    @Transactional
    public void addDeveloper(Developer developer) {
        //company.getEntities().add(developer);
        entityManager.persist(developer);

    }

    @Override
    public void addPM(PM pm) {
        company.getEntities().add(pm);
    }

    @Override
    @Transactional
    public Employer<ITRole> getEmployerByIndex(int index) {
        //Employer<ITRole> employer = company.getEntities().get(index);
        Developer developer =  entityManager.find(Developer.class, index);
        log.info("persistence contains object " + entityManager.contains(developer));
        entityManager.detach(developer);
        log.info("persistence contains object " + entityManager.contains(developer));
        return developer;
    }

    @Override
    public List<Employer<ITRole>> getEmployerByRole(ITRole role) {
        List<Employer<ITRole>> employers = company.getEntities().stream()
                .filter(employer -> employer.getRole().equals(role))
                .collect(Collectors.toList());
        return employers;
    }
}

package ru.mattakvshi.sixspring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mattakvshi.sixspring.company.ITCompany;
import ru.mattakvshi.sixspring.company.employee.Developer;
import ru.mattakvshi.sixspring.company.employee.Employee;
import ru.mattakvshi.sixspring.company.employee.ITRole;
import ru.mattakvshi.sixspring.company.employee.PM;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
//    @Qualifier("RequestScopedCompany")
    private ITCompany company;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Integer createCompany(ITCompany company){
        //entityManager.persist(company.getDirector());
       // entityManager.flush();
        entityManager.persist(company);
        entityManager.flush();
        return company.getId();
    }

    @Override
    public ITCompany getCompany(int id) {
        return entityManager.find(ITCompany.class, id);
    }

    @Override
    @Transactional
    public void addDeveloper(Developer developer, int company_id) {
        //company.getEntities().add(developer);
        developer.setCompany(getCompany(company_id));
        entityManager.persist(developer);
//        entityManager.flush();
//        entityManager.detach(developer);
//        developer.setAge(30);
//        developer.setRole(ITRole.QA);
//        entityManager.merge(developer);

    }

    @Override
    @Transactional
    public void addPM(PM pm, int company_id) {
        //company.getEmployees().add(pm);
        pm.setCompany(getCompany(company_id));
        entityManager.persist(pm);
    }

    @Override
    @Transactional
    public Employee<ITRole> getEmployerByIndex(int index) {
        //Employer<ITRole> employer = company.getEntities().get(index);
        Developer developer =  entityManager.find(Developer.class, index);
        log.info("persistence contains object " + entityManager.contains(developer));
        entityManager.detach(developer);
        log.info("persistence contains object " + entityManager.contains(developer));
        return developer;
    }

    @Override
    public List<Employee> getEmployerByRole(ITRole role, int company_id) {

//        List<Employee<ITRole>> employees = company.getEmployees().stream()
//                .filter(employer -> employer.getRole().equals(role))
//                .collect(Collectors.toList());

        List<Employee> employees = entityManager.createQuery(
                "select e from Employee e where e.role = :role and e.company = :company", Employee.class)
                .setParameter("role", role)
                .setParameter("company", getCompany(company_id))
                .getResultList();

        return employees;
    }

    @Override
    public List<Employee> getEmployerByAge(int age, int company_id){
//        List<Employee> employees = entityManager.createNativeQuery(
//                "SELECT e FROM employees WHERE e.age = :age AND e.company = :company;", Employee.class)
//                .setParameter("age", age)
//                .setParameter("company", getCompany(company_id))
//                .getResultList();

                List<Employee> employees = entityManager.createQuery(
                "SELECT e FROM Employee e WHERE e.age = :age AND e.company = :company", Employee.class)
                .setParameter("age", age)
                .setParameter("company", getCompany(company_id))
                .getResultList();
        return employees;
    }
}

package ru.mattakvshi.fivespring.company;



import ru.mattakvshi.fivespring.company.employer.Employer;
import ru.mattakvshi.fivespring.company.employer.ITRole;

import java.util.Objects;

public class ITCompany extends EmployerManager<Employer<ITRole>> {
    private String name;

    private Employer<ITRole> director;

    public ITCompany(String companyName){
        super();
        this.name = companyName;
    }

    public void startWork(){
        getEntities().forEach(worker -> {
            worker.work();
            System.out.println(worker.getName() + "is" + worker.getRole());
        });
    }

    public String getName(){
        return name;
    }

    public Employer<ITRole> getDirector() {
        return director;
    }

    public void setDirector(Employer<ITRole> director) {
        this.director = director;
    }

    @Override
    public String toString(){
        return "ITCompany{" +
                "name='" + name + "'" +
                "}";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITCompany itCompany = (ITCompany) o;
        return Objects.equals(name, itCompany.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

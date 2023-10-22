package ru.mattakvshi.onespring.company;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mattakvshi.onespring.company.employer.Employer;
import ru.mattakvshi.onespring.company.employer.ITRole;

import java.util.Objects;


@Component("CompanyComponent")
public class ITCompany extends EntityManager<Employer>{
    //@Value("Denegro inc.")
    private String name;

    @Autowired
    private Employer<ITRole> director;

//    public ITCompany(){
//        super(100,Employer.class);
//    }

    public ITCompany(
            @Qualifier("CompanyName") String companyName,
            @Qualifier("MaxEmployerCount") int maxEmployerCount){
        super(maxEmployerCount, Employer.class);
        this.name = companyName;
    }

    public void startWork(){
        for(int i = 0; i < this.getSize(); i++){
            Employer[] workers = this.getEntities();
            Employer worker = workers[i];
            worker.work();
            //Можно проще workers[i].work();

            System.out.println(worker.getName() + " is " + worker.getRole());
        }
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

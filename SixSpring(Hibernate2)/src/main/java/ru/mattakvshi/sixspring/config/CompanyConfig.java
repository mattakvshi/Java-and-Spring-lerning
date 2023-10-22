package ru.mattakvshi.sixspring.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import ru.mattakvshi.sixspring.company.ITCompany;
import ru.mattakvshi.sixspring.company.employee.Employee;
import ru.mattakvshi.sixspring.company.employee.ITRole;

@Slf4j
@Configuration
@ComponentScan("ru.mattakvshi.sixspring.company")
public class CompanyConfig {
   @Bean
   @Primary //С помощью этой анотации мы зззадаём бин по умолчанию, чтобы, если у нас множество бинов, контест спринга не ломался, не зная какие бины брать
   public ITCompany getITCompany(Employee<ITRole> director){
        ITCompany company = new ITCompany("Denegro inc.");
        company.setDirector(director);
        return company;
    }

    @Bean("RequestScopedCompany")
    @RequestScope
    public ITCompany getRequestScopedCompany(Employee<ITRole> director){
        log.info("create request scoped bean");
        ITCompany company = new ITCompany("Engenigers group");
        company.setDirector(director);
       return company;
    }

    @Bean("SessionScopedCompany")
    @SessionScope
    public ITCompany getSessionScopedCompany(Employee<ITRole> director){
        log.info("create session scoped bean");
        ITCompany company = new ITCompany("Engenigers group");
        company.setDirector(director);
        return company;
    }

    @Bean("PrototypeScopedCompany")
    @Scope("prototype")
    public ITCompany getPrototypeScopedCompany(Employee<ITRole> director){
        log.info("create prototyped scoped bean");
        ITCompany company = new ITCompany("Engenigers group");
        company.setDirector(director);
        return company;
    }

    @Bean
    public Employee<ITRole> getDirector(){
        return new Employee<>("Oleg", 30, ITRole.Director){
            @Override
            public void work() {
                System.out.println(this.getName() + " is directing");
            }
        };
    }

    @Bean("CompanyName")
    public String getCompanyName(){
        return "Denegro inc.";
    }

    @Bean("MaxEmployerCount")
    public int getCount(){
        return 100;
    }
}

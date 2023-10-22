package ru.mattakvshi.threespring.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.RequestScope;
import ru.mattakvshi.threespring.company.ITCompany;
import ru.mattakvshi.threespring.company.employer.Employer;
import ru.mattakvshi.threespring.company.employer.ITRole;

@Slf4j
@Configuration
@ComponentScan("ru.mattakvshi.threespring.company")
public class CompanyConfig {
   @Bean
   @Primary //С помощью этой анотации мы зззадаём бин по умолчанию, чтобы, если у нас множество бинов, контест спринга не ломался, не зная какие бины брать
   public ITCompany getITCompany(Employer<ITRole> director){
        ITCompany company = new ITCompany("Denegro inc.");
        company.setDirector(director);
        return company;
    }

    @Bean("RequestScopedCompany")
    @RequestScope
    public ITCompany getRequestScopedCompany(Employer<ITRole> director){
        log.info("create request scoped bean");
        ITCompany company = new ITCompany("Engenigers group");
        company.setDirector(director);
       return company;
    }

    @Bean
    public Employer<ITRole> getDirector(){
        return new Employer<>("Oleg", 30, ITRole.Director){
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

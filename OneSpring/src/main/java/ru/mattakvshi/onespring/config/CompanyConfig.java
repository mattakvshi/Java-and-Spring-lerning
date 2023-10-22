package ru.mattakvshi.onespring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.mattakvshi.onespring.company.ITCompany;
import ru.mattakvshi.onespring.company.employer.Employer;
import ru.mattakvshi.onespring.company.employer.ITRole;

@Configuration
@ComponentScan("ru.mattakvshi.onespring.company")
public class CompanyConfig {

//   @Bean
//   @Primary //С помощью этой анотации мы зззадаём бин по умолчанию, чтобы, если у нас множество бинов, контест спринга не ломался, не зная какие бины брать
//   public ITCompany getITCompany(Employer<ITRole> director){
//        ITCompany company = new ITCompany("Denegro2.0 inc.", 100);
//        company.setDirector(director);
//        return company;
//    }
//
//    @Bean
//    public ITCompany getAnotherItCompany(){
//        return new ITCompany("Engenigers group", 200);
//    }

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

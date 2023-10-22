package ru.mattakvshi.twospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mattakvshi.twospring.config.CompanyConfig;
import ru.mattakvshi.twospring.company.ITCompany;

@SpringBootApplication
public class  Program
{
    public static void main( String[] args )
    {
        SpringApplication.run(Program.class, args);
    }

}

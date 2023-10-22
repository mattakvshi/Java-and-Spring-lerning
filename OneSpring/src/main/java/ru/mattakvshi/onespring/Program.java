package ru.mattakvshi.onespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mattakvshi.onespring.config.CompanyConfig;
import ru.mattakvshi.onespring.company.ITCompany;

public class  Program
{
    public static void main( String[] args )
    {
        //ApplicationContext context  = new AnnotationConfigApplicationContext("ru.mattakvshi.onespring.company");
        ApplicationContext context = new AnnotationConfigApplicationContext(CompanyConfig.class);


        //ITCompany company = context.getBean("CompanyComponent",ITCompany.class);
        //ITCompany company = (ITCompany) context.getBean("CompanyComponent"); //не самвый безопасный вариант
        ITCompany company = context.getBean(ITCompany.class);
        System.out.println(company.getName());
        System.out.println(company.getDirector());
    }

}

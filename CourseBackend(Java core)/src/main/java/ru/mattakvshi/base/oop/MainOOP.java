package ru.mattakvshi.base.oop;

import ru.mattakvshi.base.oop.employer.Employer;
import ru.mattakvshi.base.oop.employer.QA;
import ru.mattakvshi.base.oop.employer.PM;
import ru.mattakvshi.base.oop.employer.Developer;

public class MainOOP {
    public static void main(String[] args){
        //Принцип Барбары Лесков
        Employer pm = new PM("Alex Smirnov", 30);
        Employer qa = new QA("Olga Malibu", 27);
        Employer developer = new Developer("Maks Sidorenko", 20, "Java");

//        List<Worker>workers = Arraya.asList(pm, qa, developer);
//        workers.stream().forEach(w -> w.work());


        //В классе EntityManager у нас есть метод addEntity, поэтому,
        // так как класс ITCompany наследует класс EntityManager, мы можем ипользовать этот метод.

        ITCompany company = new ITCompany("Enginiggas", 100);

        ITCompany company2 = new ITCompany("Enginiggas", 100);

        ITCompany company3 = new ITCompany("Denegro", 13);

        System.out.println("----------------------------");
        company.addEntity(pm);
        company.addEntity(qa);
        company.addEntity(developer);
        System.out.println("----------------------------");
        company.startWork();
        System.out.println("----------------------------");
        //В случае представленном ниже компилятор сам понимает, что после названия экземпляра класса
        // должно идти .toString()
        System.out.println("Company: " + company);
        System.out.println("----------------------------");
        System.out.println("Company:" + company2);
        System.out.println("----------------------------");
        System.out.println("Company:" + company3);
        System.out.println("----------------------------");
        System.out.println(company.equals(company2));
        System.out.println("----------------------------");
        System.out.println(company.equals(company3));
        System.out.println("----------------------------");

    }
}

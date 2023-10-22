package ru.mattakvshi.base.oop;

import ru.mattakvshi.base.oop.employer.Employer;

import java.util.Objects;


//Изначально я передавал параметром в EntityManager, интерфейс Worker,
// но таким образом мы можем пользоваться только методом work(), поэтому обобщим другим способом.
// Мы передадим в EntityManager абстрактный класс Employer, и тогда сможем получить имя и роль каждого рабочего.
public class ITCompany extends EntityManager<Employer>{
    private String name;

    public ITCompany(String companyName, int maxEmployerCount){
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

    @Override
    public String toString(){
        return "ITCompany{" +
                "name='" + name + "\'" +
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

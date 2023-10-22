package ru.mattakvshi.base.oop.employer;

public class PM extends Employer<ITRole> {

    public PM(String name, int age){
        super(name, age, ITRole.PM);
    }
    @Override
    public void work(){
        System.out.println(this.getName() + "is managing project");
    }
}

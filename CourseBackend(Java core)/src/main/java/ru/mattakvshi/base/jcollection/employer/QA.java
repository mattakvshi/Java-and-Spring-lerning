package ru.mattakvshi.base.jcollection.employer;


public class QA extends Employer<ITRole> {

    public QA(String name, int age){
        super(name, age, ITRole.QA);
    }
    @Override
    public void work(){
        System.out.println(this.getName() + "is testing");
    }
}

package ru.mattakvshi.base.oop.employer;

public class Developer extends Employer<ITRole> {
    private String language;

    public Developer(String name, int age, String language){
        super(name, age, ITRole.Developer);
        this.language = language;
    }
    @Override
    public void work(){
        writeCode();
    }

    private void writeCode(){
        System.out.println(this.getName() + " is writing " + this.language + " code. ");
    }
}

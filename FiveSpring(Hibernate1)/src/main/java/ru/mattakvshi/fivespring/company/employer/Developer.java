package ru.mattakvshi.fivespring.company.employer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "developers")
public class Developer extends Employer<ITRole> {
    @Column(name = "language")
    private String language;

    public Developer() {
    }
    public Developer(String name, int age, String language){
        super(name, age, ITRole.Developer);
        this.language = language;
    }


    @Override
    public void work(){
        writeCode();
    }

    public static void someMethod(){System.out.println("Method 2");}

    private void writeCode(){
        System.out.println(this.getName() + " is writing " + this.language + " code. ");
    }

    public String getLanguage(){
        return language;
    }

    @Override
    public String toString() {
        return "\nDeveloper{" +
                "name='" + getName() + '\'' +
                "age='" + getAge() + '\'' +
                "language='" + language + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("use equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return Objects.equals(language, developer.language);
    }

    @Override
    public int hashCode() {
        System.out.println("use hash");
        return Objects.hash(super.hashCode(), language);
    }
}

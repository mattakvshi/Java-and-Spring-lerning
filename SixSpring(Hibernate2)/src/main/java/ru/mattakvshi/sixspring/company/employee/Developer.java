package ru.mattakvshi.sixspring.company.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "developers")
public class Developer extends Employee<ITRole> {
    @Column(name = "language")
    private String language;

    @Column(name = "grade")
    private String grade;

    @Column(name = "work_experience")
    private String workExperience;

    public Developer() {
    }
    public Developer(String name, int age, String language){
        super(name, age, ITRole.Developer);
        this.language = language;
        this.grade = grade;
        this.workExperience = workExperience;
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

    public String getGrade() {
        return grade;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return "\nDeveloper{" +
                "name='" + getName() + '\'' +
                "age='" + getAge() + '\'' +
                "language='" + language + '\'' +
                ", grade='" + grade + '\'' +
                ", workExperience='" + workExperience + '\'' +
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

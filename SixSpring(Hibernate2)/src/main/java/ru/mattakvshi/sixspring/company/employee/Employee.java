package ru.mattakvshi.sixspring.company.employee;

import ru.mattakvshi.sixspring.company.ITCompany;

import java.util.Objects;
import javax.persistence.*;

//Класс является абстрактным так как в нём не определён метот work() из интерфейса.
// (Этот метод определён у наследников данного класа)
//@MappedSuperclass

//НОВАЯ ИНФА, УБРАЛ АБСТРАКТНОСТЬ КЛАССУ, ТАК КАК ЗАДАЛ ИНТЕРФЕЙСУ WORKER ДЕФОЛТНУЮ РЕАЛИЗАЦИЮ

@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee<T> implements Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private T role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private ITCompany company;

    public Employee(){}

    public Employee(String name, int age, T role){
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public T getRole() {
        return role;
    }

    public void setRole(T role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ITCompany getCompany() {
        return company;
    }

    public void setCompany(ITCompany company) {
        this.company = company;
    }

    public static void someMethod(){System.out.println("Method 1");}

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee<?> employee = (Employee<?>) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, role);
    }
}
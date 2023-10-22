package ru.mattakvshi.sixspring.company;

import ru.mattakvshi.sixspring.company.employee.Employee;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//Изначально в EntityManager я передавал параметром некоторую переменную типа Т. Сейчас же я ограничил передачу,
//теперь передавать параметром в класс EntityManager мы можем только наследников класса Employer, но за-то теперь мы
//мы можем здесь на месте вызывать методы этого класса, так как мы точно уверенны, что все передаваемые классы,
//расширяют класс Emoloyer. (Например: entity.getName())

@MappedSuperclass
public class EmployeeManager<T extends Employee> {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private List<T> employees;

    public EmployeeManager(){

        this.employees = new ArrayList<>();
    }

    public int getSize() {
        return employees.size();
    }

    //Возвращаем массив типа T
    public List<T> getEmployees() {
        return employees;
    }

}

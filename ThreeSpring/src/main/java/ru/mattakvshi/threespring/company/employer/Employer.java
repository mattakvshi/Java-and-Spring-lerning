package ru.mattakvshi.threespring.company.employer;

import java.util.Objects;

//Класс является абстрактным так как в нём не определён метот work() из интерфейса.
// (Этот метод определён у наследников данного класа)
public abstract class Employer<T> implements Worker {
    private String name;
    private int age;
    private T role;
    public Employer(String name, int age, T role){
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
        Employer<?> employer = (Employer<?>) o;
        return age == employer.age && Objects.equals(name, employer.name) && Objects.equals(role, employer.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, role);
    }

}

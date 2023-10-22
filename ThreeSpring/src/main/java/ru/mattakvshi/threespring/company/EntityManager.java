package ru.mattakvshi.threespring.company;

import ru.mattakvshi.threespring.company.employer.Employer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//Изначально в EntityManager я передавал параметром некоторую переменную типа Т. Сейчас же я ограничил передачу,
//теперь передавать параметром в класс EntityManager мы можем только наследников класса Employer, но за-то теперь мы
//мы можем здесь на месте вызывать методы этого класса, так как мы точно уверенны, что все передаваемые классы,
//расширяют класс Emoloyer. (Например: entity.getName())
public class EntityManager<T extends Employer> {
    private List<T> entities;

    public EntityManager(){

        this.entities = new ArrayList<>();
    }

    public int getSize() {
        return entities.size();
    }

    //Возвращаем массив типа T
    public List<T> getEntities() {
        return entities;
    }

}

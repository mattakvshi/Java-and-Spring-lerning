package ru.mattakvshi.onespring.company;

import ru.mattakvshi.onespring.company.employer.Employer;

import java.lang.reflect.Array;

//Изначально в EntityManager я передавал параметром некоторую переменную типа Т. Сейчас же я ограничил передачу,
//теперь передавать параметром в класс EntityManager мы можем только наследников класса Employer, но за-то теперь мы
//мы можем здесь на месте вызывать методы этого класса, так как мы точно уверенны, что все передаваемые классы,
//расширяют класс Emoloyer. (Например: entity.getName())
public class EntityManager<T extends Employer> {
    private final T[] entities;
    int size;

    //Разобраться с этой анотаций и такой вариацией иницилизации массива!!!!!
    @SuppressWarnings("unchecked")
    public EntityManager(int maxSize, Class<T> clazz){
        this.entities = (T[]) Array.newInstance(clazz, maxSize);
    }

    public void addEntity(T entity){
        System.out.println(entity.getName() + " is added");
        entities[size] = entity;
        size++;
    }

    public int getSize() {
        return size;
    }

    //Возвращаем массив типа T
    public T[] getEntities() {
        return entities;
    }

}

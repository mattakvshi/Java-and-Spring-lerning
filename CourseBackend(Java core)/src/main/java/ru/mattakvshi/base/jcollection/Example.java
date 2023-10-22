package ru.mattakvshi.base.jcollection;

import ru.mattakvshi.base.jcollection.employer.Developer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    private static List<Developer> developers = List.of(
            new Developer("Anton Ivanov",  20, "C#"),
            new Developer("Alexsandr Emelyanenko",  20, "Java"),
            new Developer("Dmitriy Vladarchuk",  19, "C#,Java"),
            new Developer("Ivan Erushev",  21, "C#"),
            new Developer("Maksim Sidorenko",  19, "Java"),
            new Developer("Nikita Pushkarev",  22, "C++"),
            new Developer("Anton Juravlev",  19, "JS,HTML,CSS,React"),
            new Developer("Kirill Troc",  20, "Russian"),
            new Developer("Nikita Artushenko",  21, "English"),
            new Developer("Roman Huako",  20, "Dart, Flatter"),
            new Developer("Solyanik Gleb",  20, "Python, Kotlin"),
            new Developer("Agfdzgr Rdfhhldk",  56, "C"),
            new Developer("Emplouer Timlidov",  87, "Machine Code"),
            new Developer("0100110 001010010",  1010100, "01001001"),
            new Developer("Ahmad Abdulah",  8, "EptaSkript"),
            new Developer("Angulyar Asemblerov",  999775, "Strong"),
            new Developer("Roc Magazine Medved",  64, "PHP")
    );

    public static void main(String []args) {
        List<Integer> collect = developers.stream()
                .map(x ->{
                    return x.getAge();
                })
                .collect(Collectors.toList());
        int sum = collect.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Summa=" + sum);


        List<Developer> collect1 = developers.stream()
                .sorted(new Comparator<Developer>() {
                    @Override
                    public int compare(Developer o1, Developer o2) {
                        if (o1.getAge() == o2.getAge()) {
                            return 0;
                        }
                        return (o1.getAge() > o2.getAge()) ? 1 : -1;
                    }
                })
                .collect(Collectors.toList());

        System.out.println(collect1);
    }
}

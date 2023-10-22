package ru.mattakvshi.base.jcollection;

import ru.mattakvshi.base.jcollection.employer.Developer;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Example2 {
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

    public static void main(String []args){
        List<Integer> collect = developers.stream()
                .map(x -> x.getAge())//Когда у нас один исполняемый оператор,
                // то можно не открывать {} и не использовать return (В отличие от первого Example)
                .collect(Collectors.toList());
        OptionalDouble average = collect.stream()
                .mapToInt(Integer::intValue)
                .average();
        System.out.println("SredZnach=" + average);

        //Тот же самый Компаратор только через лямбда-выражение (В отличие от первого Example)
        List<Developer> collect1 = developers.stream()
                .sorted((o1, o2) -> {
                    if (o1.getAge() == o2.getAge()) {
                        return 0;
                    }
                    return (o1.getAge() > o2.getAge()) ? 1 : -1;
                })
                .collect(Collectors.toList());

        System.out.println(collect1);
    }

}

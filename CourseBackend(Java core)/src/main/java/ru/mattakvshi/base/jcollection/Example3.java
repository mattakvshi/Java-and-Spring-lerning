package ru.mattakvshi.base.jcollection;

import ru.mattakvshi.base.jcollection.employer.Developer;
import ru.mattakvshi.base.jcollection.employer.Employer;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Example3 {
    private static List<Developer> developers = List.of(
            new Developer("Anton Ivanov",  20, "C#"),
            new Developer("Alexsandr Emelyanenko",  20, "Java"),
            new Developer("Dmitriy Vladarchuk",  19, "C#,Java"),
            new Developer("Ivan Erushev",  21, "C#"),
            new Developer("Maksim Sidorenko",  19, "Java"),
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
                .map(Employer::getAge) //Здесь можно вообще отказаться от лямбда выражений 
                .collect(Collectors.toList());
        int sum = collect.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Summa=" + sum);

        //Но можное ещё более удобно вынести компаратор в отдельную конструкцию (В отличие от первых двух Example)

        Comparator<Developer> comparator = (o1, o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return 0;
            }
            return (o1.getAge() > o2.getAge()) ? 1 : -1;
        };

        List<Developer> collect1 = developers.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        System.out.println(
                "________________________________________________\n" +
                collect1
                +"\n________________________________________________"
        );

        List<Developer> javaDevelopers = developers.stream()
                //.filter(x -> x.getLanguage().equals("Java"))
                .filter(x -> "Java".equals(x.getLanguage()))
                .collect(Collectors.toList());

        System.out.println(
                "________________________________________________\n" +
                javaDevelopers
                +"\n________________________________________________"
        );

        Set<Developer> developersSet = developers.stream()
                .filter(x -> x.getAge() < 30 && x.getAge() > 18)
                .collect(Collectors.toSet());

        System.out.println(
                "________________________________________________\n" +
                developersSet
                +"\n________________________________________________"
        );

        Set<String> stringSet = developers.stream()
                .map(Developer::getLanguage)
                .collect(Collectors.toSet());

        System.out.println(
            "________________________________________________\n" +
            stringSet
            +"\n________________________________________________"
        );

        String stringName = developers.stream()
                .map(Developer::getName)
                .collect(Collectors.joining(","));

        System.out.println(
                "________________________________________________\n" +
                stringName
                +"\n________________________________________________"
        );

        developers.stream()
                .sorted(comparator)
                .map(Developer::getName)
                .limit(3)
                .forEach(System.out::println);


        Set<Integer> SetAge = developers.stream()
                .sorted(comparator)
                .map(Employer::getAge)
                .collect(Collectors.toSet());

        System.out.println(
                "________________________________________________\n" +
                SetAge
                +"\n________________________________________________"
        );

    }
}

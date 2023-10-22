package ru.mattakvshi.base.oop.job;

import java.util.ArrayList;
import java.util.List;

public class TaskManager <T extends Job>{

    List<T> tasks = new ArrayList<>();

    public void addTask(T task){
            tasks.add(task);
    }

    public void run() throws InterruptedException {
        //Мы можем вызывать у task метод run(), так как уверенны,
        // что полученный task будет имплементировать интерфейс Job.
        while (true){
            tasks.forEach(task -> task.run());
            Thread.sleep(1000);
        }
    }
}

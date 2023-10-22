package ru.mattakvshi.base.oop.job;

public class Example {
    public static void main(String [] args) throws InterruptedException {
        TaskManager taskManager = new TaskManager();
        //Мы не создаём экземпляр класса Job, а создаём анонимный класс, который реализует интерфейс Job,
        // и его пихаем в task.
        taskManager.addTask(new Job() {
            @Override
            public void run() {
                System.out.println("Task 1");
            }
        });
        taskManager.addTask(new Job() {
            @Override
            public void run() {
                System.out.println("Task 2");
            }
        });
        taskManager.addTask(new Job() {
            @Override
            public void run() {
                System.out.println("Task 3");
            }
        });
        taskManager.addTask(new Job() {
            @Override
            public void run() {
                System.out.println("Task 3");
            }
        });
        taskManager.run();
    }
}

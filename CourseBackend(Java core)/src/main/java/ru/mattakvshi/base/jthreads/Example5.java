package ru.mattakvshi.base.jthreads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Example5 {
    private  static List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    public static void main(String []args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<Integer> callable = () -> someFunc();
        Future<Integer> integerFuture = executorService.submit(callable);
        Future<Integer> integerFuture2 = executorService.submit(callable);

        System.out.println(integerFuture.get());
        System.out.println(integerFuture2.get());

        executorService.shutdown();
    }

    private static synchronized int someFunc(){
        //Для i от 0 до 100 мы добовляем в массив число большее на 1 чем последний элемент массива.
        // Последний элемент массива получаем через метод get(), передав ему индекс последнего элемента,
        // а индекс находим как длинна массива - 1
        IntStream.range(0,100).forEach(i -> nums.add(nums.get(nums.size() - 1) + 1));
        return nums.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }


}

package ru.mattakvshi.base.jthreads;

import java.util.Arrays;
import java.util.Random;

public class GnomeSort {
    static void gSort(int array[], int n){
        int i, change = 0;
        for(i = 1;i <= n;){
            if(array[i] == 0 || array[i - 1] <= array[i])i++;
            else{
                change = array[i - 1];
                array[i-1] = array[i];
                array[i] = change;
                i--;
            }
        }
    }

    public static void main(String []args){
        int []array = new int[1000];
        for(int i = 0; i < array.length; i++) array[i] = new Random().nextInt();

        System.out.println(Arrays.toString(array));

        gSort(array, array.length);

        System.out.println(Arrays.toString(array));


    }
}

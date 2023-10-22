package ru.mattakvshi.base.jthreads;

import java.util.Arrays;
import java.util.Random;

public class GFG {
    static void gnomeSort(int arr[], int n)
    {
        int index = 0;

        while (index < n) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                int temp = 0;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        return;
    }

    // Driver program to test above functions.
    public static void main(String[] args)
    {
        int []arr = new int[1000];
        for(int i = 0; i < arr.length; i++) arr[i] = new Random().nextInt(1000);

        System.out.println(Arrays.toString(arr));

        gnomeSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));

    }
}
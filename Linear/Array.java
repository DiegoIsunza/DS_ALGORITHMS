package Linear;

import java.io.*;
import java.util.*;


public class Array {

    public static int linearSearch(int array[], int key) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] ==key)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {

        // int[] years = new int[5];

        // System.out.println("Please insert the numbers you wan to store");

        // Scanner sc = new Scanner(System.in);

        // for (int i = 0; i < years.length; i++) {
        //     years[i] = sc.nextInt();
        // }
        // sc.close();
        // for (int i = 0; i < years.length; i++) {
        //     System.out.println(i+1 + ". " + years[i]);
        // }

        // *********Creation & Implementation of 2D array*******
        // int[][] a1 = new int[3][4];
        // int count = 1;
        // for(int i = 0; i < a1.length; i++) {
        //     for(int j = 0; j < a1[i].length; j ++) {
        //         a1[i][j] = count;
        //         count++;
        //     }
        // }

        // for(int i = 0; i < a1.length; i++) {
        //     for(int j = 0; j < a1[i].length; j ++) {
        //         System.out.print(a1[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // ******** Built-in Function Array and sorting********
        int a1[] = new int[] {3,6,2,9,5,8,1};
        Arrays.sort(a1);
        for (int i = 0; i < a1.length; i++) {
            
                System.out.println(a1[i]);
            
        }

       int indexValue = linearSearch(a1, 8);
       if(indexValue == -1)
        System.out.println("element not found");
        else
            System.out.println("element is found at index" + " "+(indexValue+1));
       
    }
}
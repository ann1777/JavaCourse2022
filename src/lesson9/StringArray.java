package com.company.src.lesson9;

import java.util.*;

public class StringArray {
    public String[] StringArray1;//Declaring a new StringArray1

    public void input1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of elements of StringArray: ");


        String n1 = scanner.nextLine();
        int n = Integer.parseInt(n1); // initializing numbers n of StringArray

        StringArray1 = new String[n]; // initializing a new StringArray
        for (int i = 0; i < n; i++) {
            System.out.println("Input the " + (i + 1) + " element of the String Array: ");

            StringArray1[i] = scanner.nextLine(); // inputting n StringArrays from the keyboard
        }
    }
}


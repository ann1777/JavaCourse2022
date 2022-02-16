package com.company;


public class Operators {

    // Assigning values of type int to 4 fields
    public static void main(String args[]){
        int a = 10;
        int b = 40;
        int c = 80;
        int d = 120;
        //Summing values in pairs
        int e = a + d;
        int g = b + c;
        //Displaying the result of comparing sums (true if the first sum is greater)
        System.out.println("The first sum is greater is " + (e > g));
        //Increasing the first amount by 1
        e += 1;
        //Decreasing the second sum by 2
        g -= 2;
        //Printing the result of the comparison (true if the first sum is greater)
        System.out.println("The first sum is greater is " + (e > g));
        //Returning true if at least one sum is a multiple of 2, false otherwise
        int i = e % 2;
        int k = g % 2;
        System.out.println("At least one sum is a multiple of 2 is " +( i == 0 || k == 0));
    }

}


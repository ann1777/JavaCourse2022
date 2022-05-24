package lesson9;

import java.util.*;

public class StringArray {
    public String[] StringArray1;//Declaring a new StringArray1

    public void input1() {
        Scanner scanner = new Scanner(System.in);//Initializing new reading from display scanner
        System.out.println("Input the number of elements of the StringArray: ");

        String n1 = scanner.nextLine();// Reading the value from the scanner
        int n = Integer.parseInt(n1);// Initializing numbers of StringArray n

        StringArray1 = new String[n];// Initializing a new StringArray1
        for (int i=0; i<n; i++) {
            System.out.println("Input the " + (i + 1) + " element of StringArray: ");

            StringArray1[i] = scanner.nextLine();//inputting n StrtingArray from the 4keyboard
        }
    }
}

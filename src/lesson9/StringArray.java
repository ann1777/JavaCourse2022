package lesson9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringArray {
    public String[] StringArray1;

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

    public Set<Character> process() {
        Set<Character> sett = new HashSet<>(); // initializing a set of unique characters
        int count = 0; // initializing a counter of String containing all even characters

        for (String s : StringArray1) {
            String str1 = new String(s);
            str1 = str1.replace(" ", ""); // removed str1 extra spaces

            ArrayList<Character> ch = new ArrayList<>(str1.length());
            for (char char1 : str1.toCharArray()) ch.add(char1); // getting list of str1 Characters

        }
        return sett;
    }

}


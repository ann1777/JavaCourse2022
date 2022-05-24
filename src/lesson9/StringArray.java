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

            StringArray1[i] = scanner.nextLine();//Inputting n StringArray from the keyboard
        }
    }

    public Set<Character> process() {
        Set<Character> sett = new HashSet<>();// Initializing a set of unique characters
        int count = 0;// Initializing the counter of Strings containing all even characters

        for (String s : StringArray1) {
            String str1 = new String(s);
            str1 = str1.replace(" ", "");// Removing str1 extra spaces

            ArrayList<Character> ch = new ArrayList<>(str1.length());
            for (char char1 : str1.toCharArray())
                ch.add(char1);//getting list of str1 Characters

        }
        return sett;
    }
}

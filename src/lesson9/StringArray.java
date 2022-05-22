package lesson9;

import java.util.*;

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

    protected Set<Character> process() {
        Set<Character> sett = new HashSet<>(); // initializing a set of unique characters
        int count = 0; // initializing a counter of String containing all even characters

        for (String s : StringArray1) {
            String str1 = new String(s);
            str1 = str1.replace(" ", ""); // removed str1 extra spaces

            ArrayList<Character> ch = new ArrayList<>(str1.length());
            for (char char1 : str1.toCharArray()) ch.add(char1); // getting list of str1 Characters

            Map<Character, Integer> map1 = new HashMap<>();
            for (Character c : ch) map1.put(c, 0); // finding the unique characters of the str1

            for (Character a : map1.keySet()) { // created loop for searching duplicates of Characters
                Integer k = 0; // initializing the counter of the unique Character of the string
                for (Character i : ch) { // matching the i character of the StringArray to the
                    if (a.equals(i)) { // if we found the same Character in the StringArray ch:
                        k++;           // incrementing the Character counter by 1
                        map1.put(a, k); // rewriting the number of the Character in the map1.keySet
                    }
                }
            }
            int counter = 0; // initializing the counter of the String even Characters
            for (Integer i : map1.values()) {
                if (i % 2 == 0) counter++; // incrementing the counter if the Character is even
            }
            if (counter == map1.size() && count < 2) {
                sett.addAll(map1.keySet()); // putting the String containing all even characters to the sett
                count++; // incrementing the counter of String containing all even characters
            }
        }
    return sett;
    }
}

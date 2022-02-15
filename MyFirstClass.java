package com.company;

public class MyFirstClass {

    // метод, который печатает в консоль "~~~ <возвращенное значение> ~~~".
    public static String returnGreeting(String courseName) {
        return String.format("~~~ %s course 2022 is started ~~~%n", courseName);
    }

}
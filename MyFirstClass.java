package com.company;

public class MyFirstClass {

    // метод, который печатает в консоль "~~~ <возвращенное значение> ~~~".
    public static String returnGreeting(String courseName) {
        return String.format("~~~ %s course 2022 is started ~~~%n", courseName);
    }
    //в методе main создан экземпляр второго класса
    public static void main(String[] args) {
        System.out.printf(MyFirstClass.returnGreeting("Java AQA"));
        MySecondClass secondClassInstance = new MySecondClass();
        System.out.println(secondClassInstance.returnNumberOfStudentsPresent());
    }
}
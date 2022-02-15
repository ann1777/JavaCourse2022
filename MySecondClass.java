package com.company;

public class MySecondClass {
    //   метод, который печатает в консоль "~~~<значение поля>~~~"
    public String returnNumberOfStudentsPresent() {
//    объявляем поле типа int со значением 28
        int numberOFStudentsPresentsNow = 28;
        return String.format("%n--- Today there are %s students present ---", numberOFStudentsPresentsNow);
    }
}

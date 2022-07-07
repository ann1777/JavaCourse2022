package com.company.lesson20.src.main.inheritance;

public class Man extends Person {
    public boolean isSmoking;

    public double getGrossSalary() {
        return grossSalary;
    }

    protected double grossSalary;

    public Man(String name, String lastname, int age, boolean isPartnerMale, boolean isSmoking, double salary) {
        super(name, lastname, age, isPartnerMale);
        this.isSmoking = isSmoking;
        this.grossSalary = salary;
    }

    public boolean isSmoking() {
        if (this.isSmoking) {
            return true;
        } else {
            return false;
        }
    }

    public double setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
        return this.grossSalary;
    }

    @Override
    public boolean isRetired() {
        System.out.printf("This man is %s ", age < 65 ? "still works" : "not works yet");
        if (this.age > 65) {
            return true;
        } else {
            return false;
        }
    }
}
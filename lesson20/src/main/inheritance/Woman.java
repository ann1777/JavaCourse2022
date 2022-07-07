package com.company.lesson20.src.main.inheritance;

public class Woman extends Person {
    protected int numberOfChildren;
    protected boolean isBlond;
    private double weight;

    private double lostWeight;

    public Woman(String name, String lastname, int age, boolean isPartnerMale, int numberOfChildren, boolean isBlond,
                 double lostWeight) {
        super(name, lastname, age, isPartnerMale);
        this.numberOfChildren = numberOfChildren;
        this.isBlond = isBlond;
        this.lostWeight = lostWeight;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public double getLostWeight() {
        return lostWeight;
    }

    public boolean isBlond() {
        if (this.isBlond) {
            return true;
        } else {
            return false;
        }
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void setIsBlond(boolean blond) {
        this.isBlond = blond;
    }

    public void setLostWeight(double lostWeight) {
        this.lostWeight = lostWeight;
    }

    @Override
    public boolean isRetired() {
        System.out.printf("This woman is %s retired ", age >= 60 ? "already" : "not");
        if(this.age>60) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void registerPartnership2(Person partner, boolean isPartnerMale) {
        super.registerPartnership2(partner, isPartnerMale);
        if (isPartnerMale) {
            this.setLastname(partner.lastname);
        }
    }
    public boolean isOlder(Woman woman) {
        if(this.age > woman.getAge()) {
            return true;
        }else {
            return false;
        }
    }

    public double getCurrentWeight(double weight, double lostWeight){
        this.weight = this.weight - this.lostWeight;
        return this.weight;
    }
}



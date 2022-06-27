package lesson16.src.main.java.inheritance;

public abstract class Man extends Person {
    public boolean isSmoking;
    protected double grossSalary;

    public Man(String name, String lastname, int age, boolean isPartnerMale, boolean isSmoking, double grossSalary) {
        super(name, lastname, age, isPartnerMale);
        this.isSmoking = isSmoking;
        this.grossSalary = grossSalary;
    }

    public Man() {

    }
    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }
    public boolean isSmoking() {
        if (this.isSmoking) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isRetired () {
        System.out.printf("This man is %s ", age < 65 ? "still works" : "not works already");
        return false;
    }
}

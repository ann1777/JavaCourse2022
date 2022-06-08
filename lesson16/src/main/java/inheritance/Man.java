package inheritance;

public class Man extends Person {
    public boolean isSmoking;
    protected double grosSalary;

    public Man(String name, String lastname, int age, boolean isPartnerMale, boolean isSmoking, double salary) {
        super(name, lastname, age, isPartnerMale);
        this.isSmoking = isSmoking;
        this.grosSalary = salary;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }

    public void setGrosSalary(double grosSalary) {
        this.grosSalary = grosSalary;
    }
}

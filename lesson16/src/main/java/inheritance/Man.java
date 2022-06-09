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

    @Override
    public boolean isRetired() {
        System.out.printf("This man is %s retired", (age >= 65)? "":"not");
        return (age>=65);
    }

    @Override
    public void registerPartnership(String lastname) {
    }

    @Override
    public void deregisterPartnership() {
    }
}


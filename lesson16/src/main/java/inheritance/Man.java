package inheritance;

public class Man extends Person {
    public boolean isSmoking;
    protected double grosSalary;
    Person partner;

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

    public Person getPartner() {
        return partner;
    }

    @Override
    public boolean isRetired() {
        System.out.printf("This man is %s retired", (age >= 65) ? "" : "not");
        return (age >= 65);
    }

    @Override
    public Person setPartner(Person partner) {
        this.partner = partner;
        this.lastname = partner.lastname;
        return partner;
    }

    @Override
    public void registerPartnership(String lastname) {
    }

    @Override
    public void registerPartnership2(Person partner) {
        if (this.isPartnerMale() != partner.isPartnerMale()) {
            this.setPartner(partner);
            this.partner = partner;
        }
    }

    @Override
    public void deregisterPartnership(boolean revertLastname, String birthLastname) {
        if (revertLastname) {
            this.setLastname(birthLastname);
            System.out.printf("He %s revert his lastname to " + birthLastname + " after loses his relationship with " +
                            "partner. \n", (revertLastname) ? "was" : "wasn't");
        }
    }
}
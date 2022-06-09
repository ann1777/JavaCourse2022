package inheritance;

public class Woman extends Person {
    private int numberOfChildren;
    protected boolean isBlond;
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

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void setBlond(boolean blond) {
        isBlond = blond;
    }

    public void setLostWeight(double lostWeight) {
        this.lostWeight = lostWeight;
    }

    @Override
    public boolean isRetired() {
        System.out.printf("This woman is %s retired", (age >= 60)? "" : "not");
        return (age>=60);
    }

    @Override
    public void registerPartnership (String lastname){
        this.setLastname(lastname);
    }

    @Override
    public boolean deregisterPartnership ( boolean revertLastName, String birthLastname){
        if (revertLastName) {
            this.setLastname(birthLastname);
        }
        return true;
    }
}

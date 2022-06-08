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

    public boolean isBlond() {
        return isBlond;
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
}
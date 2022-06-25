package lesson16.src.main.java.inheritance;

public class Woman extends Person {

    protected double currentWeight;
    private int numberOfChildren;

    public boolean isBlond(boolean b) {
        return isBlond;
    }

    protected boolean isBlond;
    protected double weight;
    private double lostWeight;

    public Woman(String name, String lastname, int age, boolean isPartnerMale, int numberOfChildren, boolean isBlond,
                 double lostWeight) {
        super(name, lastname, age, isPartnerMale);
        this.setNumberOfChildren(numberOfChildren);
        this.isBlond = isBlond;
        this.setLostWeight(lostWeight);
    }
    public Woman() {
        super();
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }
    public void setCurrentWeight(double weight) {
        this.weight = weight;
    }

    public double getLostWeight() {
        return lostWeight;
    }

    public boolean setIsBlond() {
        System.out.println("----- START OF Verify function isBlond in TestClassWoman class -------------");
        if (this.isBlond(false)){
            try {
                return this.isBlond(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("----- END OF Verify function isBlond in TestClassWoman class -------------");
        return this.isBlond(true);
    }
    public void setNumberOfChildren(int numberOfChildren) {
        System.out.println("----- START OF Verify function setNumberOfChildren in TestClassWoman class -------------");
        if (this.age > 18) {
            try {
                this.numberOfChildren = numberOfChildren;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            System.out.println("She is too young woman to have children.");
        }
        System.out.println("----- END OF Verify function setNumberOfChildren in TestClassWoman class -------------");
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setLostWeight(double lostWeight) {
        this.lostWeight = lostWeight;
    }
    public double getCurrentWeight(double weight, double lostWeight) {
        this.weight = weight;
        this.setLostWeight(lostWeight);
        double currentWeight = weight - lostWeight;
        return currentWeight;
    }

    @Override
    public void isRetired() {
        System.out.printf("This woman is %s retired ", age >= 60 ? "already" : "not");
    }

    @Override
    public void registerPartnership2(lesson16.src.main.java.inheritance.Person partner, boolean isPartnerMale) {
        super.registerPartnership2(partner, isPartnerMale);
        if (isPartnerMale) {
            this.setLastname(partner.lastname);
        }
    }
}

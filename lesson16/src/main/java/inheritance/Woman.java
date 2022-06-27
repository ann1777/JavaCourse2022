package lesson16.src.main.java.inheritance;

public class Woman extends Person {

    public int numberOfChildren;
    protected boolean isBlond;
    protected double weight;
    private double lostWeight;

    public Woman(String name, String lastname, int age, boolean isPartnerMale, int numberOfChildren, boolean isBlond,
                 double lostWeight) {
        super(name, lastname, age, isPartnerMale);
        this.numberOfChildren = numberOfChildren;
        this.isBlond = isBlond;
        this.lostWeight = lostWeight;
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

    public boolean isBlond(boolean b) {
        return isBlond;
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

    public void setLostWeight(double lostWeight) {
        this.lostWeight = lostWeight;
    }

    public double getCurrentWeight(double weight, double lostWeight) {
        this.weight = weight;
        this.setLostWeight(lostWeight);
        this.weight = weight - lostWeight;
        return this.weight;
    }

    @Override
    public boolean isRetired() {
        if (this.age>=60){
            System.out.println("This woman is already retired");
            return this.isRetired = true;
        }
        System.out.println("This woman is not retired yet");
        return this.isRetired = false;
    }

    @Override
    public void registerPartnership2(lesson16.src.main.java.inheritance.Person partner, boolean isPartnerMale) {
        super.registerPartnership2(partner, isPartnerMale);
        if (isPartnerMale) {
            this.setLastname(partner.lastname);
            this.partner = partner;
            this.setPartner(partner);
        }
    }
}

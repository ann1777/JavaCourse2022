public class Woman extends Person {
    protected int numberOfChildren;

    protected double weight;

    public boolean isBlond() {
        return isBlond;
    }

    protected boolean isBlond;
    private double lostWeight;

    public Woman(String name, String lastname, int age, boolean isPartnerMale, int numberOfChildren, boolean isBlond,
                 double lostWeight) {
        super(name, lastname, age, isPartnerMale);
        this.numberOfChildren = numberOfChildren;
        this.isBlond = isBlond;
        this.lostWeight = lostWeight;
    }

    public Woman(){
        super();
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setLostWeight(double lostWeight) {
        this.lostWeight = lostWeight;
    }

    public double getCurrentWeight(double weight, double lostWeight) {
        weight -= lostWeight;
        return weight;
    }

    public boolean setIsBlond(boolean isBlond) {
        if(setIsBlond(true))
        {
            System.out.println(true);
            return true;
        }
        else
        {
            System.out.println(false);
            return false;
        }
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    @Override
    public void isRetired() {
        System.out.printf("This woman is %s retired \n", age >= 60 ? "already" : "not");
    }

    @Override
    public void registerPartnership2(Person partner, boolean isPartnerMale) {
        super.registerPartnership2(partner, isPartnerMale);
        if (isPartnerMale) {
            this.setLastname(partner.lastname);
        }
    }
}

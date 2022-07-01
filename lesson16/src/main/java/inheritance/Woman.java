package main.java.inheritance;

public class Woman extends Person {
    public int numberOfChildren;
    protected boolean isBlond;
    public double weight;
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

    public boolean getIsBlond() {
        if (this.isBlond) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setIsBlond() {
            return this.isBlond=true;
        }

    public void setNumberOfChildren(int numberOfChildren) {
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
    public void registerPartnership2(Person partner, boolean isPartnerMale) {
        super.registerPartnership2(partner, isPartnerMale);
        if (isPartnerMale) {
            this.setLastname(partner.lastname);
            this.partner = partner;
            this.setPartner(partner);
        }
    }

    public boolean isOlder(Woman woman) {
        if(this.age > woman.getAge()) {
            return true;
        }else {
            return false;
        }
    }
}

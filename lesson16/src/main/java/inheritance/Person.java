package inheritance;

//class Person has name, lastname, age and isPartnerMale fields
public abstract class Person {
    protected String name;
    protected String lastname;
    protected String birthLastname;
    protected int age;
    private boolean isPartnerMale;
    protected boolean isRetired;
    protected Person partner;
//    protected boolean revertLastname;

    //constructor for class Person
    public Person(String name, String lastname, int age, boolean isPartnerMale) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.isPartnerMale = isPartnerMale;
    }

    //add setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPartnerMale(boolean partnerMale) {
        isPartnerMale = partnerMale;
    }

    //add Getters
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public boolean isPartnerMale() {
        return isPartnerMale;//return true
    }

    //create isRetired method
    public boolean isRetired() {
        return isRetired;
    }

    public abstract Person setPartner(Person partner);

    //create registerPartnership method
    public void registerPartnership(String lastname) {
    }

    //create deregisterPartnership method
    public void deregisterPartnership(boolean revertLastname, String birthLastname) {
    }

    public void registerPartnership2(Person partner) {
        if(this.isPartnerMale != partner.isPartnerMale) {
            this.setPartner(partner);
        }
    }
}

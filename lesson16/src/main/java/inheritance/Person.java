package lesson16.src.main.java.inheritance;

//class Person has name, lastname, age and isPartnerMale fields
public abstract class Person {
    protected String name;
    protected String lastname;
    protected String birthLastname;
    protected int age;
    private boolean isPartnerMale;
    protected boolean isRetired;
    protected boolean revertLastname;
    protected Person partner;

    //constructor for class Person
    public Person(String name, String lastname, int age, boolean isPartnerMale) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.isPartnerMale = isPartnerMale;
    }

    public Person() {
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

    public void setBirthLastname(String birthLastname) {
        this.birthLastname = birthLastname;
    }

    public boolean revertLastname() {
        this.revertLastname = true;
        this.setLastname(birthLastname);
        return false;
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

    //create isRetired method
    public boolean isRetired() {
        return this.isRetired = true;
    }

    public void setPartner(Person partner){
        this.partner = partner;
    }


    //create registerPartnership method get Person as data
    public void registerPartnership2(Person partner, boolean isPartnerMale) {
        if(this.isPartnerMale != partner.isPartnerMale){
            this.partner = partner;
            this.setPartner(partner);
        }
    }

    //create deregisterPartnership method
    public void deregisterPartnership(boolean revertLastname, String birthLastname) {
        if(revertLastname) {
            this.lastname = birthLastname;
            this.partner.setPartner(null);
            this.partner.setLastname(this.partner.birthLastname);
            this.partner = null;
        }
    }
}


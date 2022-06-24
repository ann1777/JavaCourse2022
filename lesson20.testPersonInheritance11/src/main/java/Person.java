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

    public void setRetired(boolean retired) {
        isRetired = retired;
    }

    public void revertLastname(boolean revertLastname) {
        this.revertLastname = true;
        this.setLastname(birthLastname);
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
//
//    public String getBirthLastname() {
//        return birthLastname;
//    }
//
//    public boolean isRevertLastname() {
//        return revertLastname;
//    }

//    public Person getPartner() {
//    }

//    public boolean isPartnerMale() {
//        return isPartnerMale;//return true
//    }

    //create isRetired method
    public void isRetired() {
    }

    public void setPartner(Person partner){
        this.partner = partner;
    }

    //create registerPartnership method
//    public void registerPartnership(String lastname) {
//    }

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

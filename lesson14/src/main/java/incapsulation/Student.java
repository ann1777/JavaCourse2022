package incapsulation;

//class Student has private ID, name and lastname fields
public class Student {
    private int ID;
    private String name;
    private String lastname;

    //constructor for class Student
    public Student(int ID, String name, String lastname) {
        this.ID = ID;
        this.name = name;
        this.lastname = lastname;
    }

    //empty constructor for class Student
    public Student() {
    }

    //setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //getters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}

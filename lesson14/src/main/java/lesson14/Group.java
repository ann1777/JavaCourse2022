package lesson14;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

//class represents students group has groupLeader, students list and listOfTasks fields
public class Group {
    private int groupID;
    private ArrayList<Student> students;
    private Student groupLeader;
    private Map<Integer, String> listOfTasks;
    private LinkedHashMap<Integer, Map<Integer, Boolean>> studentTasks;

    public Group(Student groupLeader, ArrayList<Student> students) {
        this.students = students;
        this.groupLeader = groupLeader;
    }

    public Group() {
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setGroupLeader(Student groupLeader) {
        this.groupLeader = groupLeader;
    }

    public void groupLeaderToGroup() {
        students.add(groupLeader);
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    //change group leader method
    public void changeGroupLeader(Student student) {
        this.groupLeader = student;
    }

    public void printGroupID() {
        System.out.println("Group ID: "+ groupID);
    }

    public void printGroupLeader() {
        System.out.println("Group Leader: " + groupLeader.getID() + " " +groupLeader.getName() + " " + groupLeader.getLastname());
    }

    public void printStudents() {
        int i=1;
        for (Student s : students) {
            System.out.println("Student "+i+": "+s.getID()+" "+s.getName()+" "+s.getLastname());
            i++;
        }
    }

    public void printValue(){
        printGroupID();
        printGroupLeader();
        printStudents();
    }

    //add student to group method
    public void addStudent(Student student) {
        students.add(student);
    }

    //remove student
    public void removeStudent(Student student) {
        students.remove(student);
    }

    //rename student
    public void renameStudent(Student student, String name) {
        student.setName(name);
    }




}

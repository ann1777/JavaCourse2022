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

}

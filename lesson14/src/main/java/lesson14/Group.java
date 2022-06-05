package lesson14;

import java.util.ArrayList;
import java.util.HashMap;
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
        System.out.println("Group ID: " + groupID);
    }

    public void printGroupLeader() {
        System.out.println("Group Leader: " + groupLeader.getID() + " " + groupLeader.getName() + " " + groupLeader.getLastname());
    }

    public void printStudents() {
        int i = 1;
        for (Student s : students) {
            System.out.println("Student " + i + ": " + s.getID() + " " + s.getName() + " " + s.getLastname());
            i++;
        }
    }

    public void printValue() {
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

    //add task for whole group
    public void setTasksForGroup() {
        LinkedHashMap<Integer, Map<Integer, Boolean>> studentTasks = new LinkedHashMap<>();
        for (Student s : students) {
            Map<Integer, Boolean> tasks = new HashMap<>();
            for (Integer t : listOfTasks.keySet()) {
                tasks.put(t, false);
            }
            studentTasks.put(s.getID(), tasks);
        }
        this.studentTasks = studentTasks;
    }

    public void printStudentsTasks() {
        for (Student s : students) {
            System.out.println("Tasks of the student ID" + s.getID() + " " + s.getName() + " " + s.getLastname());
            System.out.println(studentTasks.get(s.getID()));
        }
    }

    public void printTasksOfTheStudent(int ID) {
        int k = 0;
        for (Student s : students) {
            if (s.getID() == ID) {
                System.out.println("Tasks of student ID" + s.getID() + " " + s.getName() + " " + s.getLastname());
                System.out.println(studentTasks.get(ID));
                k++;
            }
        }
        if (k == 0) {
            System.out.println("There are no students with this ID!");
        }
    }

    public void setListOfTasks(Map<Integer, String> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Map<Integer, String> getListOfTasks() {
        return listOfTasks;
    }

    public void printListOfTasks() {
        System.out.println("Group tasks:");
        int i = 1;
        for (String s : listOfTasks.values()) {
            System.out.println("Task " + i + ": " + s);
            i++;
        }
    }

    public void markDone(int ID, Integer taskID) {
        int k = 0;
        for (Student s : students) {
            if (s.getID() == ID) {
                for (Map<Integer, Boolean> t : studentTasks.values()) {
                    for (int i : t.keySet()) {
                        if (i == taskID) {
                            studentTasks.get(ID).replace(taskID, false, true);
                            k++;
                        }
                    }
                }
            }
        }
        if (k == 0) {
            System.out.println("There are no students with this ID or tasks with this TaskID!");
        }
    }
}


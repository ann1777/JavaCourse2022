package incapsulation;

import java.util.*;

//class represents students group has groupLeader, students list and listOfTasks fields
public class Group {
    private int groupID;
//    private ArrayList<Student> students;
    private HashSet<Student> students;
    private Student groupLeader;
    private Map<Integer, String> listOfTasks;
    private LinkedHashMap<Integer, Map<Integer, Boolean>> studentTasks;

    public Group(Student groupLeader, HashSet<Student> students, Map<Integer, String> listOfTasks, LinkedHashMap<Integer, Map<Integer, Boolean>> studentTasks) {
        this.students = new HashSet<>(students);
        this.groupLeader = groupLeader;
        this.listOfTasks = new HashMap<>();
        this.studentTasks = new LinkedHashMap<>();
    }

    public Group(Student groupLeader, HashSet<Student> students) {
        this.students = new HashSet<>(students);
        this.groupLeader = groupLeader;
    }


    public void setStudents(HashSet<Student> students) {
        this.students = students;
    }

    public void setGroupLeader(Student groupLeader) {
        this.groupLeader = groupLeader;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
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

    //add student to the group method
    public void addStudent(Student student) {
        int k = 0;
        for (Student s : students) {
            if ((s).equals(student)) {
                System.out.println("Student with ID№" + student.getID() + " is already present in this group.");
                k++;
            }
        } if (k == 0) {
            students.add(student);
            System.out.println("Student with ID№" + student.getID() + " has been added to the group.");
        }
    }

    //remove student
    public void removeStudent(Student student) {
        students.remove(student);
    }

    //rename student
    public void renameStudent(Student student, int ID, String name) {
        int a = 0;
        for (Student s : students) {
            if (s.getID() == ID) {
                s.setName(name);
                a++;
            } else if (a == 0){
                System.out.println("There are no students with this ID.");
            }
        }
    }

    //change group leader method
    public void changeGroupLeader(int ID) {
        int a = 0;
        for (Student s : students) {
            if (s.getID() == ID) {
                this.setGroupLeader(s);
                a++;
            }
        }
        if (a == 0) {
            System.out.println("There are no students with this ID.");
        }
    }

    //checking if student already present in the Group
    public void equals(Student student) {
        int k = 0;
        for (Student s : students) {
            if ((s).equals(student)) {
                System.out.println("Student with ID№" + student.getID() + " is present in this group.");
                k++;
            }
        }
        if (k == 0) {
            System.out.println("Student with ID№" + student.getID() + " is absent in this group.");
        }
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
        System.out.println("The results of Group №" + groupID + " students tasks are:");
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
            } else if (k == 0) {
                System.out.println("There are no students with ID" + ID + "!");
                break;
            }
        }
    }

    public void setListOfTasks(Map<Integer, String> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public HashSet<Student> getStudents() {
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

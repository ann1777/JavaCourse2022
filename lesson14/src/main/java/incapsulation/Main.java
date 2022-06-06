package incapsulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(111, "Ivan", "Potap");
        Student student2 = new Student(234, "Kirill", "Gnatenko");
        Student student3 = new Student(345, "Olesya", "Bondarenko");
        Student student4 = new Student(456, "Yulia", "Zhurba");
        Student student5 = new Student(567, "Kirill", "Nechitailo");
        student1.setID(123);
        student1.setName("Tanya");
        student1.setLastname("Potapchuk");
        System.out.println(student1.getID());
        System.out.println(student1.getName());
        System.out.println(student1.getLastname());

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Group group1 = new Group(student2, new ArrayList<>());
        group1.setGroupID(2);
        group1.printGroupID();
        group1.printValue();
        group1.setGroupLeader(student1);
        group1.setStudents(students);
        System.out.println("-------------");
        group1.printValue();

        group1.changeGroupLeader(student2);
        System.out.println("-------------");
        group1.printValue();
        Student student6 = new Student(678, "Stepan", "Bandera");
        group1.addStudent(student6);
        System.out.println("-------------");
        group1.printValue();
        group1.removeStudent(student4);
        System.out.println("-------------");
        group1.printValue();
        group1.renameStudent(student1, "Tatiana");
        group1.printValue();
        System.out.println("-------------");

        Map<Integer, String> group1Tasks = new HashMap<>();
        group1Tasks.put(1, "Study ArrayList");
        group1Tasks.put(2, "Study Massive");
        group1Tasks.put(3, "Code Program1");
        group1Tasks.put(4, "Debug Program1");
        System.out.println(group1Tasks);
        group1.setListOfTasks(group1Tasks);
        group1.printListOfTasks();
        group1.setTasksForGroup();
        System.out.println("-------------");

        group1.printStudentsTasks();
        System.out.println("-------------");
        group1.printTasksOfTheStudent(123);
        System.out.println("-------------");
        group1.printTasksOfTheStudent(2);
        group1.markDone(123, 2);
        group1.markDone(123, 3);
        group1.printTasksOfTheStudent(111);
        System.out.println("~~~~~~~~~~~~~");
        group1.printStudentsTasks();
        group1.markDone(234, 1);
        group1.markDone(234, 2);
        group1.markDone(345, 3);
        group1.markDone(345, 4);
        group1.markDone(456, 2);
        System.out.println("-------------");
        group1.printStudentsTasks();
        Student student7 = new Student(1111);
        System.out.println(student7.getID());
        student7.setName("Tom");
        System.out.println(student7.getName());
//        students.add(student7);
//        group1.printStudentsTasks();
//        group1.studentIsPresent(student7);
        Student student8 = new Student(9663);
        group1.equals(student1);
        group1.equals(student7);
        group1.addStudent(student7);
        group1.addStudent(student1);
        group1.equals(student8);
        group1.addStudent(student2);

    }
}

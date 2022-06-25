package incapsulation;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

        HashSet<Student> group = new HashSet<>();
        group.add(student1);
        group.add(student2);
        group.add(student3);
        group.add(student4);
        group.add(student5);

        Group group1 = new Group(student1, group);
        group1.setGroupID(2);
        group1.printGroupID();
        group1.printValue();
        System.out.println("__/___/___/___/___");
        group1.setGroupLeader(student3);
//        group.setStudents(students);
        group1.printValue();
        System.out.println("-------------");
        group1.changeGroupLeader(123);
        group1.printValue();
        System.out.println("--|----|----|---");
        Student student6 = new Student(678, "Stepan", "Bandera");
        group1.addStudent(student6);
        System.out.println("-------------");
        group1.printValue();
        group1.removeStudent(student4);
        System.out.println("-------------");
        group1.printValue();
        group1.renameStudent(student1, 123,"Tatiana");
        group1.printValue();
        System.out.println("~~~~~~~~~~~~~~");

        Map<Integer, String> groupTasks = new HashMap<>();
        groupTasks.put(1, "Study ArrayList");
        groupTasks.put(2, "Study Massive");
        groupTasks.put(3, "Code Program1");
        groupTasks.put(4, "Debug Program1");
        System.out.println(groupTasks);
        group1.setListOfTasks(groupTasks);
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
        group1.equals(student7);
        group1.addStudent(student1);
        group1.equals(student8);
        group1.addStudent(student2);

    }
}
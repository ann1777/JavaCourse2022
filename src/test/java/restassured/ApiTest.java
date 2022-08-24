package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static org.hamcrest.Matchers.*;

public class ApiTest extends BaseTest {
    @Test(description = "new students post and get query tests")
    public void createAndGetStudents() {
        Response student1CreateResponse = RestAssured.given()
                .body(new StudentData("Oleksandr", "Svidersky"))
                .post("/students");
        student1CreateResponse.then().statusCode(200);
        Student student1 = student1CreateResponse.as(Student.class);
        Response student2CreateResponse = RestAssured.given()
                .body(new StudentData("Angela", "Potapchuk"))
                .post("/students");
        student2CreateResponse.then().statusCode(200);
        Student student2 = student2CreateResponse.as(Student.class);
        Response student3CreateResponse = RestAssured.given()
                .body(new StudentData("Andrii", "Parail"))
                .post("/students");
        student3CreateResponse.then().statusCode(200);
        Student student3 = student3CreateResponse.as(Student.class);
        Response student1GetResponse = RestAssured.get("/students/{id}", student1.id);
        Student receivedStudent1 = student1GetResponse.as(Student.class);
        Assert.assertEquals(receivedStudent1.firstName, "Oleksandr");
        Assert.assertEquals(receivedStudent1.lastName, "Svidersky");
        Response student2GetResponse = RestAssured.get("/students/{id}", student2.id);
        Student receivedStudent2 = student2GetResponse.as(Student.class);
        Assert.assertEquals(receivedStudent2.firstName, "Angela");
        Assert.assertEquals(receivedStudent2.lastName, "Potapchuk");
        Response student3GetResponse = RestAssured.get("/students/{id}", student3.id);
        Student receivedStudent3 = student3GetResponse.as(Student.class);
        Assert.assertEquals(receivedStudent3.firstName, "Andrii");
        Assert.assertEquals(receivedStudent3.lastName, "Parail");
        Student[] allStudents = RestAssured.get("/students").as(Student[].class);
        Assert.assertEquals(allStudents.length, 3);
        System.out.println(Arrays.asList(allStudents));
    }
    @Test(description = "search students by part of name query test")
    public void testStudentSearch() {
        RestAssured.given()
                .body(new StudentData("Oleksandr", "Svidersky"))
                .post("/students")
                .then().statusCode(200);
        RestAssured.given()
                .body(new StudentData("Angela", "Potapchuk"))
                .post("/students")
                .then().statusCode(200);
        RestAssured.given()
                .body(new StudentData("Volodymyr", "Golovach"))
                .post("/students")
                .then().statusCode(200);
        Response response = RestAssured.given()
                .queryParam("last_name", "ch")
                .when().get("/students");
        response.then().statusCode(200);
        Student[] searchResult = response.as(Student[].class);
        Assert.assertEquals(searchResult.length, 2);
        Set<String> names = Arrays.stream(searchResult).map(s -> s.firstName).collect(Collectors.toSet());
        Assert.assertEquals(names, Set.of("Angela", "Volodymyr"));
    }

    @Test(description = "get students ID query test")
    public void testGetStudentsIDList() {
        RestAssured.given()
                .body(new StudentData("Ivan", "Litvinau"))
                .post("/students")
                .then().statusCode(200);
        RestAssured.given()
                .body(new StudentData("Dmytro", "Bidenko"))
                .post("/students")
                .then().statusCode(200);
        RestAssured.given()
                .body(new StudentData("Valentyna", "Mykhaiova"))
                .post("/students")
                .then().statusCode(200);
        List<Student> allStudents = Arrays.asList(
                RestAssured.get("/students")
                        .then().statusCode(200)
                        .extract().as(Student[].class)
        );
        List<Integer> studentIds = allStudents.stream().map(student -> student.id).collect(Collectors.toList());
        Assert.assertFalse(studentIds.size() == 0);
        System.out.println(studentIds.size());
        System.out.println(studentIds.stream().toList());
    }

    @Test(description = "create new group post query test")
    public void createNewGroup() {
        List<Student> allStudents = Arrays.asList(
                RestAssured.get("/students")
                        .then().statusCode(200)
                        .extract().as(Student[].class)
        );
        List<Integer> studentIds = allStudents.stream().map(student -> student.id).collect(Collectors.toList());
        Response group1CreateResponse = RestAssured.given()
                .body(new GroupData("aqaGroup", studentIds))
                .post("/groups");
        group1CreateResponse.then().statusCode(200);
        Group group1 = group1CreateResponse.as(Group.class);
        Assert.assertEquals(group1.name, "aqaGroup");
        Group[] groups = RestAssured.get("/groups").as(Group[].class);
        Assert.assertEquals(groups.length, 1);
    }

    @Test(description = "create assignment content query test")
    public void createGroupTask() {
        Group[] group1 = RestAssured.get("/groups").as(Group[].class);
        String group1TaskContent = "Create API test framework";
        Response contentTaskResponce = RestAssured.given()
                .body(new AssignmentContentData("Create API test framework"))
                .post("/content");
        contentTaskResponce.then().statusCode(200);
        AssignmentContentData group1Task = contentTaskResponce.as(AssignmentContentData.class);
        Assert.assertEquals(group1Task.content, group1TaskContent);
    }
    @Test(description = "assign the group task for students query test")
    public void assigningGroupTask() {
        RestAssured.given()
                .body(new StudentData("Ivan", "Litvinau"))
                .post("/students")
                .then().statusCode(200);
        Student[] students = RestAssured.get("/students").as(Student[].class);
        List<Student> allStudents = Arrays.asList(
                RestAssured.get("/students")
                        .then().statusCode(200)
                        .extract().as(Student[].class)
        );
        List<Integer> studentIds = allStudents.stream().map(student -> student.id).collect(Collectors.toList());
        Response group1CreateResponse = RestAssured.given()
                .body(new GroupData("aqaGroup", studentIds))
                .post("/groups");
        group1CreateResponse.then().statusCode(200);
        Group[] group1 = RestAssured.get("/groups").as(Group[].class);
        String group1TaskContent = "Create API test framework";
        Response contentTaskResponce = RestAssured.given()
                .body(new AssignmentContentData("Create API test framework"))
                .post("/content");
        contentTaskResponce.then().statusCode(200);
        AssignmentContentData[] assignmentContentData = RestAssured.get("/content").as(AssignmentContentData[].class);
        Integer student_id = students[0].id;
        Integer content_id = assignmentContentData[0].id;
        AssignmentGroupTask assignmentGroupTask = RestAssured.given()
                .body(new CreateAssignmentForGroup("student", student_id, content_id))
                .post("/assignments")
                .then().statusCode(200)
                .extract().as(AssignmentGroupTask.class);
        Assert.assertEquals(assignmentGroupTask.studentId, student_id);
        Assert.assertEquals(assignmentGroupTask.contentId, content_id);
    }
}
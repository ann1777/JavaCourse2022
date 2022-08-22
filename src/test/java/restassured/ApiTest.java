package restassured;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ApiTest extends BaseTest{

        @Test
    public void createAndGetStudents() {
        //create new student1 post query
        Response student1CreateResponse = RestAssured.given()
                .body(new StudentData("Oleksandr", "Svidersky"))
                .post("/students");
        student1CreateResponse.then().statusCode(200);
        Student student1 = student1CreateResponse.as(Student.class);
        //create new student2 post query test
        Response student2CreateResponse = RestAssured.given()
                .body(new StudentData("Angela", "Potapchuk"))
                .post("/students");
        student2CreateResponse.then().statusCode(200);
        Student student2 = student2CreateResponse.as(Student.class);
        //create new student3 post query test
        Response student3CreateResponse = RestAssured.given()
                .body(new StudentData("Andrii", "Parail"))
                .post("/students");
        student3CreateResponse.then().statusCode(200);
        Student student3 = student3CreateResponse.as(Student.class);
        //student1 get by ID query test
        Response student1GetResponse = RestAssured.get("/students/{id}", student1.id);
        Student receivedStudent1 = student1GetResponse.as(Student.class);
        Assert.assertEquals(receivedStudent1.firstName, "Oleksandr");
        Assert.assertEquals(receivedStudent1.lastName, "Svidersky");
        //student2 get by ID query test
        Response student2GetResponse = RestAssured.get("/students/{id}", student2.id);
        Student receivedStudent2 = student2GetResponse.as(Student.class);
        Assert.assertEquals(receivedStudent2.firstName, "Angela");
        Assert.assertEquals(receivedStudent2.lastName, "Potapchuk");
        //student3 get by ID query test
        Response student3GetResponse = RestAssured.get("/students/{id}", student3.id);
        Student receivedStudent3 = student3GetResponse.as(Student.class);
        Assert.assertEquals(receivedStudent3.firstName, "Andrii");
        Assert.assertEquals(receivedStudent3.lastName, "Parail");

        Student[] allStudents = RestAssured.get("/students").as(Student[].class);
        Assert.assertEquals(allStudents.length, 3);
        System.out.println(Arrays.asList(allStudents));
    }

    @Test
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

    @Test
    public void testStudentDashboard() {
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
        Assert.assertNotNull(studentIds.size());
        System.out.println(studentIds.size());
    }

    @Test
    public void createNewGroup(){
        //create new group post query test
        Student[] group1Students = RestAssured.get("/students").as((Type) Student[].class);
        Response group1CreateResponse = RestAssured.given()
                .body(new GroupData("aqaGroup", List.of(group1Students)))
                .post("/groups");
        group1CreateResponse.then().statusCode(200);
        Group group1 = group1CreateResponse.as(Group.class);
        Assert.assertEquals(group1.name, "aqaGroup");
    }

    @Test
    public void createGroupTask() {
        //create assignment content
        Group[] group1 = RestAssured.get("/groups").as((Type) Group[].class);
        Response group1TaskResponse = RestAssured.given()
                .body(new GroupData("Create API test framework"))
                .post("/content");
        group1TaskResponse.then().statusCode(200);
        Group group1Task = group1TaskResponse.as(Group.class);
    }

    @Test
    public void assigningGroupTask() {
        //assign the group task for students
        Response student1CreateAssignment = RestAssured.given()
                .body(new AssignmentContentData("student1", "0", "Create API test framework schema"))
                .post("/assignments");
        student1CreateAssignment.then().statusCode(200);
        AssignmentContentData student1 = student1CreateAssignment.as(AssignmentContentData.class);
        Response student2CreateAssignment = RestAssured.given()
                .body(new AssignmentContentData("student2", "1", "Create API test framework schema"))
                .post("/assignments");
        student2CreateAssignment.then().statusCode(200);
        AssignmentContentData student2 = student2CreateAssignment.as(AssignmentContentData.class);
    }
}

package restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class BaseTest {
    private final String userNamePrefix = "testApiUser";

    private final String password = "testApiPass";

    private String userName;

    private String sessionToken;

    //get user login base test
    @BeforeMethod
    public void setUp() throws JSONException {
        RestAssured.reset();
        RestAssured.baseURI = "https://www.robotdreams.karpenko.cc/";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
        userName = userNamePrefix + randomAlphanumeric(5);
        JSONObject user = new JSONObject();
        user.put("username", userName);
        user.put("password", password);

        RestAssured.given()
                .body(user.toString())
                .when()
                .post("/user").then().statusCode(200);
        Response sessionResponse = RestAssured.given()
                .queryParam("username", userName)
                .queryParam("password", password)
                .when()
                .get("/login");
        sessionResponse.then().statusCode(200);
        JSONObject joTokenResponse = new JSONObject(sessionResponse.asString());
        sessionToken = joTokenResponse.getString("session_token");
        System.out.println(sessionToken);
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("user-token", sessionToken)
                .build();
    }
}

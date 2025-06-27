import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PetStoreAPITest {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void getUser(){
        RestAssured.get("/user/IntoPunto");
    }

    @Test
    public void login(){
        RestAssured.get("/user/login?username=%C4%B1ntopunto3&password=3435");
    }

    @Test
    public void createUser(){
        String payload = "{\n" +
                "  \"id\": 47,\n" +
                "  \"username\": \"IntoPunto\",\n" +
                "  \"firstName\": \"İntizar\",\n" +
                "  \"lastName\": \"Güzelçay\",\n" +
                "  \"email\": \"gzlcayintizar@gmai.com\",\n" +
                "  \"password\": \"12345\",\n" +
                "  \"phone\": \"05467865779\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        RestAssured.given()
                .body(payload)
                .contentType(ContentType.JSON)
                .when()
                .post("/user")
                .then()
                .statusCode(200);
    }

    @Test
    public void updateUser(){
        Map<String, Object> bodyPayload = new HashMap<>();
        bodyPayload.put("id","48");
        bodyPayload.put("userName","IntoPunto");
        bodyPayload.put("firstName","ıntızar");
        bodyPayload.put("lastName","guzelcay");
        bodyPayload.put("email","gzlcayintizar@gmail.com");
        bodyPayload.put("password","123456");
        bodyPayload.put("phone","05467865779");
        bodyPayload.put("userState","0");

        Map<String,Object> headerPayload = new HashMap<>();
        headerPayload.put("accept","application/json");
        headerPayload.put("content-type","application/json");

        RestAssured.given()
                .body(bodyPayload)
                .headers(headerPayload)
                .contentType(ContentType.JSON)
                .when()
                .put("/user/IntoPunto")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteUser(){
        Map<String ,Object> headerPayload = new HashMap<>();
        headerPayload.put("accept","application/json");
        RestAssured.given()
                .headers(headerPayload)
                .contentType(ContentType.JSON)
                .when()
                .delete("/user/IntoPunto3 ")
                .then()
                .statusCode(200);
    }

    @Test
    public void logout(){
        RestAssured.get("/user/logout");
    }

    @Test
    public void createWithArray(){
        String bodyPayload = "[\n" +
                "  {\n" +
                "    \"id\": 6,\n" +
                "    \"username\": \"Gul2\",\n" +
                "    \"firstName\": \"Gulnaz\",\n" +
                "    \"lastName\": \"fırat\",\n" +
                "    \"email\": \"fırat@gmail.com\",\n" +
                "    \"password\": \"123\",\n" +
                "    \"phone\": \"05466788990\",\n" +
                "    \"userStatus\": 0\n" +
                "  },\n" +
                " {\n" +
                "    \"id\": 7,\n" +
                "    \"username\": \"Gul12\",\n" +
                "    \"firstName\": \"Gulnaz1\",\n" +
                "    \"lastName\": \"fırat1\",\n" +
                "    \"email\": \"fırat1@gmail.com\",\n" +
                "    \"password\": \"1234\",\n" +
                "    \"phone\": \"05466788998\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";

        RestAssured.given()
                .body(bodyPayload)
                .contentType(ContentType.JSON)
                .when()
                .post("/user/createWithArray")
                .then()
                .statusCode(200);
    }

    @Test
    public void createWithList(){
        String bodyPayload = "[\n" +
                "   {\n" +
                "    \"id\": 676,\n" +
                "    \"username\": \"Gul74\",\n" +
                "    \"firstName\": \"Gulnaz\",\n" +
                "    \"lastName\": \"fırat\",\n" +
                "    \"email\": \"fırat@gmail.com\",\n" +
                "    \"password\": \"123\",\n" +
                "    \"phone\": \"05466788990\",\n" +
                "    \"userStatus\": 0\n" +
                "  },\n" +
                " {\n" +
                "    \"id\": 57,\n" +
                "    \"username\": \"Gul95\",\n" +
                "    \"firstName\": \"Gulnaz1\",\n" +
                "    \"lastName\": \"fırat1\",\n" +
                "    \"email\": \"fırat1@gmail.com\",\n" +
                "    \"password\": \"1234\",\n" +
                "    \"phone\": \"05466788998\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";
        RestAssured.given()
                .body(bodyPayload)
                .contentType(ContentType.JSON)
                .when()
                .post("/user/createWithList")
                .then()
                .statusCode(200);
    }
}


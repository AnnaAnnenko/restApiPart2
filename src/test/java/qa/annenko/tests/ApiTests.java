package qa.annenko.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import qa.annenko.models.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.Is.is;

public class ApiTests {

    @Test
    public void totalOfGetListOfUserTest() {
        ResponseListOfUser response = given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(ResponseListOfUser.class);
//                .body("total", is(12));
        assertThat(response.getTotal() == 12);
    }

    @Test
    public void itemsOfGetListOfUserTest() {
        ResponseListOfUser response = given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(ResponseListOfUser.class);
        assertThat(response.getData().get(0).getLast_name().equals("Lawson"));
        assertThat(response.getData().get(1).getLast_name().equals("Ferguson"));
        assertThat(response.getData().get(2).getLast_name().equals("Funke"));
    }

    @Test
    public void singleUserNotFoundTest() {

        given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().body()
                .statusCode(404);
    }

    @Test
    public void createUserTest() {

        RequestCreateUser bodyRequest = new RequestCreateUser();
        bodyRequest.setName("morpheus");
        bodyRequest.setJob("leader");

        ResponseCreateUser response = given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(bodyRequest)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().body()
                .statusCode(201)
                .extract().as(ResponseCreateUser.class);
        assertThat(response.getName().equals("morpheus"));
        assertThat(response.getJob().equals("leader"));
    }

    @Test
    public void updateUserTest() {

        RequestCreateUser bodyRequest = new RequestCreateUser();
        bodyRequest.setName("morpheus");
        bodyRequest.setJob("zion resident");

        ResponseCreateUser response = given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(bodyRequest)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(ResponseCreateUser.class);
        assertThat(response.getName().equals("morpheus"));
        assertThat(response.getJob().equals("zion resident"));
    }

    @Test
    public void deleteUserTest() {

        given()
                .log().uri()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .statusCode(204);
    }

    @Test
    public void unSuccessfulLoginTest() {

        RequestUnsuccessfulLogin bodyRequest = new RequestUnsuccessfulLogin();
        bodyRequest.setEmail("peter@klaven");

        ResponseUnsuccessfulLogin response= given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(bodyRequest)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().body()
                .statusCode(400)
                .extract().as(ResponseUnsuccessfulLogin.class);
        assertThat(response.getError().equals("Missing password"));
    }
}
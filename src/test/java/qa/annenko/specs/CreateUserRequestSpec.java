package qa.annenko.specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static qa.annenko.helpers.CustomApiListener.withCustomTemplates;

public class CreateUserRequestSpec {

    public static RequestSpecification createUserRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("/api/users")
            .log().all()
            .contentType(JSON);
}

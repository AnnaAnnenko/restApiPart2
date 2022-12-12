package qa.annenko.specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static qa.annenko.helpers.CustomApiListener.withCustomTemplates;

public class UnsuccessfulLoginRequestSpec {

    public static RequestSpecification unsuccessfulLoginRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("/api/login")
            .log().all()
            .contentType(JSON);
}

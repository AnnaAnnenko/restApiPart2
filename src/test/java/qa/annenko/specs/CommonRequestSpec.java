package qa.annenko.specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static qa.annenko.helpers.CustomApiListener.withCustomTemplates;

public class CommonRequestSpec {

    public static RequestSpecification commonRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("/api/users")
            .log().all();
}

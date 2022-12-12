package qa.annenko.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.notNullValue;

public class SingleUserNotFoundResponseSpec {

    public static ResponseSpecification singleUserNotFoundResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(404)
            .build();
}

package qa.annenko.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.notNullValue;

public class DeleteUserResponseSpec {

    public static ResponseSpecification deleteUserResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(204)
            .build();
}

package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeletRequest {

    private RequestSpecification spec;
    private Response response;

    @Given("I set DELETE employee service api endpoints")
    public void i_set_delete_employee_service_api_endpoints() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseUrl")).build();
        spec.pathParams("pp1","delete","pp2",7);
    }

    @When("I send DELETE HTTP request")
    public void i_send_delete_http_request() {
        response=given().spec(spec).when().delete("/{pp1}/{pp2}");
    }

    @Then("I receive valid HTTP response code {int}")
    public void i_receive_valid_http_response_code(Integer status) {
        response.then().assertThat().statusCode(status);

    }

    @And("data is {string}")
    public void dataIs(String data) {

        response.then().assertThat().body("data",
                equalTo(data));
    }

    @And("status is success")
    public void statusIsSuccess() {
        response.then().assertThat().body("status",equalTo("success"));
    }

    @And("message is Successfully! Record has been deleted")
    public void messageIsSuccessfullyRecordHasBeenDeleted() {
        response.then().assertThat().body("message",equalTo("Successfully! Record has been deleted"));
    }


}

package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.PostPutRequestBody.BodyDummy;
import pojos.PostPutRequestBody.DummyData;
import utilities.ConfigReader;
import utilities.JsonUtils;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PutRequest {

    private RequestSpecification spec;
    private Response response;
    private DummyData datadummy;
    private BodyDummy expectedData;
    private  BodyDummy actualdata;


    @Given("I set PUT employee service api endpoints")
    public void i_set_put_employee_service_api_endpoints() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseUrl")).build();
        spec.pathParams("pp1","update","pp2",21);

    }
    @When("I set Update request Body")
    public void i_set_update_request_body() {
        datadummy=new DummyData("Olan","15400","57");
       expectedData=new BodyDummy("success",datadummy,"Successfully! Record has been updated.");

    }
    @When("Send PUT HTTP request")
    public void send_put_http_request() {
        response = given().spec(spec).contentType(ContentType.JSON).body(datadummy).when().put("/{pp1}/{pp2}");

        response.prettyPrint();
    }
    @Then("I receive valid HTTP response code {int} for put Request")
    public void iReceiveValidHTTPResponseCodeForPutRequest(int status) {
        assertEquals(status,response.getStatusCode());

    }

    @Then("Response body should be like the following")
    public void response_body_should_be_like_the_following() {

        actualdata= JsonUtils.convertJsonToJavaObject(response.asString(),BodyDummy.class);
        assertEquals(expectedData.getData().getAge(),actualdata.getData().getAge());
        assertEquals(expectedData.getData().getName(),actualdata.getData().getName());
        assertEquals(expectedData.getData().getSalary(),actualdata.getData().getSalary());
        assertEquals(expectedData.getStatus(),actualdata.getStatus());

    }



}

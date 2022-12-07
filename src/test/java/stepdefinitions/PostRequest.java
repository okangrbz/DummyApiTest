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

public class PostRequest {
    private RequestSpecification spec;
    private Response response;
    private DummyData datadummy;
    private BodyDummy expectedData;
    private  BodyDummy actualdata;



    @Given("I set POST employee service api endpoints")
    public void i_set_post_employee_service_api_endpoints() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseUrl")).build();
        spec.pathParam("pp1","create");


    }
    @When("I set request header")
    public void i_set_request_header() {
        datadummy=new DummyData("Peles","18000","70");
        expectedData=new BodyDummy("success",datadummy,"Successfully! Record has been added.");

    }
    @When("Send a POST HTTP request")
    public void send_a_post_http_request() {

        response = given().spec(spec).contentType(ContentType.JSON).body(datadummy).when().post("/{pp1}");

        response.prettyPrint();
    }

    @Then("I receive valid Response")
    public void i_receive_valid_response() {
        assertEquals(200,response.getStatusCode());


    }
    @Then("Response body for POST request should be like the following")
    public void response_body_for_post_request_should_be_like_the_following() {
        actualdata= JsonUtils.convertJsonToJavaObject(response.asString(),BodyDummy.class);
        assertEquals(expectedData.getData().getAge(),actualdata.getData().getAge());
        assertEquals(expectedData.getData().getName(),actualdata.getData().getName());
        assertEquals(expectedData.getData().getSalary(),actualdata.getData().getSalary());
        assertEquals(expectedData.getStatus(),actualdata.getStatus());
        assertEquals(expectedData.getMessage(),actualdata.getMessage());

    }

}

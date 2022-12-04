package stepdefinitions;

import BaseUrl.DumyRestApi;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeletRequest extends DumyRestApi {
    /*
    URL: https://dummy.restapiexample.com/api/v1/delete/2
   HTTP Request Method: DELETE Request
   Test Case: Type by using Gherkin Language
   Assert:     i) Status code is 200
           ii) "status" is "success"
          iii) "data" is "2"
           iv) "message" is "Successfully! Record has been deleted"
 */
	/*
	Given
		https://dummy.restapiexample.com/api/v1/delete/2
	When
		User send request for delet
	Then
		Status code is 200
	And
		"status" is "success"
	And
		"data" is "2"
	And
		"message" is "Successfully! Record has been deleted"
	 */

    @Test
    public void delet01() {

        spec.pathParams("pp1","delete","pp2",2);

        Response response=given().spec(spec).when().delete("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("status",equalTo("success"),"data",
                equalTo("2"),"message",equalTo("Successfully! Record has been deleted"));



    }

}

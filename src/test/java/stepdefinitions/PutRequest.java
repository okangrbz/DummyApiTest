package stepdefinitions;

import BaseUrl.DumyRestApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DataDummy;
import pojos.DummyBody;
import utilities.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PutRequest extends DumyRestApi {

    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */
	/*
	Gherkil Language

	Given
		https://dummy.restapiexample.com/api/v1/update/21
	And
		Request body: {
                        "employee_name": "Baba Bura Gel",
                        "employee_salary": 5454554,
                        "employee_age": 100,
                        "profile_image": "Null image"
                     }
    When
    	User send Put request
    Then
		Status code is 200
	And
		Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
	 */

    @Test
    public void put01() {
        spec.pathParams("pp1","update","pp2",21);

        DataDummy datadummy=new DataDummy("Baba Bura Gel",5454554,100,"Null image");
        DummyBody expectedData=new DummyBody("success",datadummy,"Successfully! Record has been updated.");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(datadummy).when().put("/{pp1}/{pp2}");

        DummyBody actualdata= JsonUtils.convertJsonToJavaObject(response.asString(),DummyBody.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getStatus(),actualdata.getStatus());
        assertEquals(expectedData.getData().getProfileImage(),actualdata.getData().getProfileImage());
        assertEquals(expectedData.getData().getEmployeeAge(),actualdata.getData().getEmployeeAge());
        assertEquals(expectedData.getData().getEmployeeSalary(),actualdata.getData().getEmployeeSalary());
        assertEquals(expectedData.getData().getEmployeeName(),actualdata.getData().getEmployeeName());
        assertEquals(expectedData.getMessage(),actualdata.getMessage());



    }

}

package stepdefinitions;

import BaseUrl.DumyRestApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DataDummy;
import pojos.DummyBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostRequest extends DumyRestApi {

    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
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
        "employee_name": "baba Hanks",
        "employee_salary": 111111,
        "employee_age": 23,
        "profile_image": "Perfect image",
        "id": 8389
    },
    "message": "Successfully! Record has been added."
}
     */

	/*
	Gherkin Language

	Given
		https://dummy.restapiexample.com/api/v1/create

	{
    "employee_name": "Tom Hanks",
     "employee_salary": 111111,
    "employee_age": 23,
     "profile_image": "Perfect image"
     }
	When
		User send Post request
	Then
		Status code is 200
	And
		Response body should be like the following
{
    "status": "success",
    "data": {
        "employee_name": "baba Hanks",
        "employee_salary": 111111,
        "employee_age": 23,
        "profile_image": "Perfect image",
        "id": 8389
    },
    "message": "Successfully! Record has been added."
}

	 */

    @Test
    public void post01() {
        //1.Step
        spec.pathParam("pp1","create");

        //2.Step: Set the  expecteddata
        DataDummy dummData=new DataDummy("Tom Hanks",111111,23,"Perfect image");
        DummyBody expectedData= new DummyBody("success",dummData,"Successfully! Record has been added.");

        //3. sent the request et set the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(dummData).when().post("/{pp1}");
        //response.prettyPrint();


        //4.Step: Do assertion

        DummyBody actualdata=response.as(DummyBody.class);// bu sekilde de oluyor

        //DummyBody actualdata=JsonUtils.convertJsonToJavaObject(response.asString(),DummyBody.class);//asString() olamali toString() ile calismaz
        assertEquals(200,response.getStatusCode());//assert ler Junit classindan olmasi lazim
        assertEquals(expectedData.getStatus(),actualdata.getStatus());
        assertEquals(expectedData.getData().getProfileImage(),actualdata.getData().getProfileImage());
        assertEquals(expectedData.getData().getEmployeeAge(),actualdata.getData().getEmployeeAge());
        assertEquals(expectedData.getData().getEmployeeSalary(),actualdata.getData().getEmployeeSalary());
        assertEquals(expectedData.getData().getEmployeeName(),actualdata.getData().getEmployeeName());
        assertEquals(expectedData.getMessage(),actualdata.getMessage());

    }
}

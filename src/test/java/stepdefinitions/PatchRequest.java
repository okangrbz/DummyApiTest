package stepdefinitions;

import BaseUrl.DumyRestApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class PatchRequest extends DumyRestApi {

}

    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									   }
     */



        //1.Step: Set the Url
/*
        spec.pathParams("pp1","todos","pp2",198);

        //2.Step: Set expectedData

        jsonplaceholderTestData expectedData=new jsonplaceholderTestData();
        Map<String,Object> requestBodyMap=expectedData.expectedDataWithMissinKeys(null,"Wash the dishes",null);

        //3.Step: Send the Put request et get response
        Response respon= given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().patch("/{pp1}/{pp2}");
        respon.prettyPrint();

        //4.Step: Do assertion

        Map<String,Object> mapAssertAllDetails=expectedData.expectedDataWithAllKeys(10,"Wash the dishes",true);


        respon.then().assertThat().statusCode(200).body("title",equalTo(mapAssertAllDetails.get("title")),
                "completed",equalTo(mapAssertAllDetails.get("completed")),
                "userId",equalTo(mapAssertAllDetails.get("userId")));



    }
*/
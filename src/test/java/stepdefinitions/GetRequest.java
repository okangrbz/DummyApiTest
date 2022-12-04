package stepdefinitions;

import BaseUrl.DumyRestApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest extends DumyRestApi {

    /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */

	/*
	Given
		https://dummy.restapiexample.com/api/v1/employees
	When
		User send get request
	Then
		Status code is 200
	And
		There are 24 employees
	And
		"Tiger Nixon" and "Garrett Winters" are among the employees
	And
         The greatest age is 66
    And
          The name of the lowest age is "Tatyana Fitzpatrick"
    And
          Total salary of all employees is 6,644,770
	 */

    @Test
    public void get01ObjectMapperpojo() {
        //1.Step: set the url
        spec.pathParams("pp1","employees"); //iii) "Tiger Nixon" and "Garrett Winters" are among the employees


        //2.Set the expected data
        //burda expected data olusutrmayacagizjsonpacht ile
        // ayri ayri manipulation yapacagiz

        //3.Send the request and get the response
        Response response = given().spec(spec).when().get("/{pp1}");
        //response.prettyPrint();

        //4.Do assertion
        response.
                then().
                assertThat().
                statusCode(200).//i.Statutcode
                body("data.id",hasSize(24),//ii) There are 24 employees
                "data.employee_name",hasItems("Tiger Nixon","Tatyana Fitzpatrick"));

        //iv) The greatest age is 66
        JsonPath jsonpath=response.jsonPath();
        List<Integer> ageList=jsonpath.getList("data.findAll{it.id}.employee_age");
        Collections.sort(ageList);
        System.out.println(ageList);
        assertTrue(ageList.get(ageList.size()-1)==66);

        //v) The name of the lowest age is "Tatyana Fitzpatrick"
        List<String> nameoftelowesage=jsonpath.get("data.findAll{it.employee_age==" + ageList.get(0) + "}.employee_name");
        String actualplusjeun="";
        for (String each:nameoftelowesage) {
            actualplusjeun+=each;
        };

        assertEquals("Tatyana Fitzpatrick",actualplusjeun);

        // vi) Total salary of all employees is 6,644,770
        List<Integer>employeSalaries=jsonpath.getList("data.employee_salary");
        System.out.println(employeSalaries);
        int totlesalarie=0;
        for (Integer each:employeSalaries) {
            totlesalarie+=each;
        }
        //System.out.println(totlesalarie);
        assertEquals(6644770,totlesalarie);


        //2. yol lamda ile
        int totaolsalery=employeSalaries.stream().reduce(Integer::sum).get();//Bu int class ile yapilisi
        int totalLammdaRedouce=employeSalaries.stream().reduce(0,(t,u)->t+u);//buda redouce ile yapilisi
        int totalLmdamath=employeSalaries.stream().reduce(0,Math::addExact);//buda math clasindan
        assertEquals(6644770,totaolsalery);







    }
}

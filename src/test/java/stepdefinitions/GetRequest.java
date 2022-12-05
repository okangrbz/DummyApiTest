package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;
import java.util.Collections;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest  {

    private RequestSpecification spec;
    private Response response;
    private JsonPath jsonpath;



    @Given("I set GET employee service api endpoints")
    public void i_set_get_employee_service_api_endpoints() {
        spec=new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("baseUrl")).build();
        spec.pathParams("pp1","employees");
    }
    @When("Send GET HTTP request")
    public void send_get_http_request() {
         response = given().spec(spec).when().get("/{pp1}");

    }

    @Then("I receive valid HTTP response code {int} for Get Request")
    public void iReceiveValidHTTPResponseCodeForGetRequest(int statut) {
        response.
                then().
                assertThat().
                statusCode(statut);
        response.prettyPrint();

    }


    @Then("There are {int} employees")
    public void there_are_employees(Integer size) {

        response.
                then().
                assertThat().
                body("data.id",hasSize(size));

    }


    @And("{string} and {string} are among the employees")
    public void andAreAmongTheEmployees(String name1, String name2) {
        response.
                then().
                assertThat().body(
                "data.employee_name",hasItems(name1,name2));

    }
    @Then("The greatest age is {int}")
    public void the_greatest_age_is(Integer age) {
         jsonpath=response.jsonPath();
        List<Integer> ageList=jsonpath.getList("data.findAll{it.id}.employee_age");
        Collections.sort(ageList);
        System.out.println(ageList);
        assertTrue(ageList.get(ageList.size()-1)==age);


    }

    @Then("Total salary of all employees is {double}")
    public void total_salary_of_all_employees_is(double salarie) {

        List<Integer>employeSalaries=jsonpath.getList("data.employee_salary");
        System.out.println(employeSalaries);
        int totaolsalery=employeSalaries.stream().reduce(Integer::sum).get();//wicht Class Integer
        int totalLammdaRedouce=employeSalaries.stream().reduce(0,(t,u)->t+u);//wicht JavaLammda
        int totalLmdamath=employeSalaries.stream().reduce(0,Math::addExact);//wicht Class Math
        assertEquals(6644770,totalLammdaRedouce);

    }


}

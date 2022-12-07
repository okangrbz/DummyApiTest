
@Crud
Feature: Test CRUD methods in Sample Employee REST API testing

  @Post
  Scenario: TC01 Add Employee record
    Given I set POST employee service api endpoints
    When I set request header
    And Send a POST HTTP request
    Then I receive valid Response
    And Response body for POST request should be like the following

  @Put
  Scenario: TC02 Update Employee record
    Given I set PUT employee service api endpoints
    When I set Update request Body
    And Send PUT HTTP request
    Then I receive valid HTTP response code 200 for put Request
    And Response body should be like the following

  @Get
  Scenario: TC03 Get Employee record
    Given I set GET employee service api endpoints
    When Send GET HTTP request
    Then I receive valid HTTP response code 200 for Get Request
    And There are 24 employees
    And "Tiger Nixon" and "Tatyana Fitzpatrick" are among the employees
    And The greatest age is 66
    And Total salary of all employees is 6644770

  @Delete
  Scenario: TC04 Delete Employee record
    Given I set DELETE employee service api endpoints
    When I send DELETE HTTP request
    Then I receive valid HTTP response code 200
    And data is "11"
    And status is success
    And message is Successfully! Record has been deleted
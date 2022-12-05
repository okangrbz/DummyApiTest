package pojos.PostPutRequestBody;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyData {

        /*

{
    "status": "success",
    "data": {
        "name": "test",
        "salary": "123",
        "age": "23",
        "id": 25
    }
}
     */
    private String name;
    private String salary;
    private String age;
    private int id;

    public DummyData() {
    }

    public DummyData(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

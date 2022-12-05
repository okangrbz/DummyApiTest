package pojos.PostPutRequestBody;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyDummy {

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

    private String status;
    private DummyData data;
    private String message;

    public BodyDummy() {
    }

    public BodyDummy(String status, DummyData data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyData getData() {
        return data;
    }

    public void setData(DummyData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

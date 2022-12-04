package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyBody {

	@JsonProperty("status")
	private String status;
	@JsonProperty("data")
	private DataDummy data;
	@JsonProperty("message")
	private String message;
	public DummyBody(String status, DataDummy data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public DummyBody() {

	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("data")
	public DataDummy getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(DataDummy data) {
		this.data = data;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DummyBody{" +
				"status='" + status + '\'' +
				", data=" + data +
				", message='" + message + '\'' +
				'}';
	}
}

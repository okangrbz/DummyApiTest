package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDummy {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("employee_name")
	private String employeeName;
	@JsonProperty("employee_salary")
	private Integer employeeSalary;
	@JsonProperty("employee_age")
	private Integer employeeAge;
	@JsonProperty("profile_image")
	private String profileImage;


	public DataDummy() {
	}

	public DataDummy(String employeeName, Integer employeeSalary, Integer employeeAge, String profileImage) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.profileImage = profileImage;
	}


	@JsonProperty("employee_name")
	public String getEmployeeName() {
		return employeeName;
	}

	@JsonProperty("employee_name")
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@JsonProperty("employee_salary")
	public int getEmployeeSalary() {
		return employeeSalary;
	}

	@JsonProperty("employee_salary")
	public void setEmployeeSalary(Integer employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	@JsonProperty("employee_age")
	public int getEmployeeAge() {
		return employeeAge;
	}

	@JsonProperty("employee_age")
	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}

	@JsonProperty("profile_image")
	public String getProfileImage() {
		return profileImage;
	}

	@JsonProperty("profile_image")
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(DataDummy.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null)?"<null>":this.id));
		sb.append(',');
		sb.append("employeeName");
		sb.append('=');
		sb.append(((this.employeeName == null)?"<null>":this.employeeName));
		sb.append(',');
		sb.append("employeeSalary");
		sb.append('=');
		sb.append(((this.employeeSalary == null)?"<null>":this.employeeSalary));
		sb.append(',');
		sb.append("employeeAge");
		sb.append('=');
		sb.append(((this.employeeAge == null)?"<null>":this.employeeAge));
		sb.append(',');
		sb.append("profileImage");
		sb.append('=');
		sb.append(((this.profileImage == null)?"<null>":this.profileImage));
		sb.append(',');
		if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
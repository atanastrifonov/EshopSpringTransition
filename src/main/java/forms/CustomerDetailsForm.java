package forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDetailsForm {
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String phone;
	
	@NotNull
	@Size(max=100)
	private String address;
	
	@NotNull
	private String cityRegion;
	
	private String ccNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityRegion() {
		return cityRegion;
	}

	public void setCityRegion(String cityRegion) {
		this.cityRegion = cityRegion;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	
	
}

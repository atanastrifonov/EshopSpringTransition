package forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDetailsForm {
	
	@NotNull
	@Size(min=2, max=16, message="{name.size.error}")
	private String name;
	
	@NotNull
	@Size(min=2, max=32, message="{email.size.error}")
	private String email;
	
	@NotNull
	@Size(min=2, max=16, message="{phone.size.error}")
	private String phone;
	
	@NotNull
	@Size(min=2, max=16, message="{address.size.error}")
	private String address;
	
	@NotNull
	@Size(min=1, max=16, message="{city.region.size.error}")
	private String cityRegion;
	
	@NotNull
	@Size(min=2, max=16, message="{cc.number.size.error}")
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

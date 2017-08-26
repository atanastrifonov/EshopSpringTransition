package dto;

public class CustomerData {

	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String cityRegion;
	private String ccNumber;
	
	public CustomerData(String name, String email, String phone, String address, String cityRegion, String ccNumber) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.cityRegion = cityRegion;
		this.ccNumber = ccNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	public static class Builder{
		private String nestedName;
		private String nestedEmail;
		private String nestedPhone;
		private String nestedAddress;
		private String nestedCityRegion;
		private String nestedCCNumber;
		
		public Builder(){
			
		}

		public Builder setNestedName(String nestedName) {
			this.nestedName = nestedName;
			return this;
		}

		public Builder setNestedEmail(String nestedEmail) {
			this.nestedEmail = nestedEmail;
			return this;
		}

		public Builder setNestedPhone(String nestedPhone) {
			this.nestedPhone = nestedPhone;
			return this;
		}

		public Builder setNestedAddress(String nestedAddress) {
			this.nestedAddress = nestedAddress;
			return this;
		}

		public Builder setNestedCityRegion(String nestedCityRegion) {
			this.nestedCityRegion = nestedCityRegion;
			return this;
		}

		public Builder setNestedCCNumber(String nestedCCNumber) {
			this.nestedCCNumber = nestedCCNumber;
			return this;
		}
		
		public CustomerData build(){
			return new CustomerData(nestedName, nestedEmail, nestedPhone, nestedAddress, nestedCityRegion, nestedCCNumber);
		}
	}

}

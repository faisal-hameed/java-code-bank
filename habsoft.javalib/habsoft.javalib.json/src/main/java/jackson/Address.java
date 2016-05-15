package jackson;

public class Address {
	private String country;
	private String city;
	private String stNo;

	
	
	public Address() {
		super();
	}

	public Address(String country, String city, String stNo) {
		super();
		this.setCountry(country);
		this.city = city;
		this.stNo = stNo;
	}

	@Override
	public String toString() {
		return "Address [country=" + getCountry() + ", city=" + city + ", stNo=" + stNo + "]";
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStNo() {
		return stNo;
	}

	public void setStNo(String stNo) {
		this.stNo = stNo;
	}

}

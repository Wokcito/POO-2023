package tp_04;

public class Province {
	
	private String name;
	private Country country;
	
	// Constructors
	public Province(String name, Country country) {
		this.name = name;
		this.country = country;
	}
	
	// Methods
	public String toString() {
		return "Provincia: " + this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Country getCountry() {
		return this.country;
	}
}
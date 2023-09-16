package tp_04;

import java.util.List;
import java.util.ArrayList;

public class Continent {
	
	public String name;
	private List<Country> countries = new ArrayList<Country>(); 	
	
	// Constructors
	public Continent(String name, List<Country> countries) {
		this.name = name;
		this.countries = countries;
	}
	
	public Continent(String name) {
		this.name = name;
	}
	
	// Methods
	public String toString() {
		return "Continente: " + this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Country> getCountries() {
		return this.countries;
	}
	
	public void addCountry(Country country) {
		this.countries.add(country);
	}
}
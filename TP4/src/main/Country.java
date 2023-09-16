package tp_04;

import java.util.List;
import java.util.ArrayList;

public class Country {
	
	private String name;
	private String capital;
	private Continent continent;
	private List<Province> provinces = new ArrayList<Province>();
	private List<Country> borderingCountries = new ArrayList<Country>();
	
	// Constructors
	public Country(String name, String capital, Continent continent, List<Province> provinces, List<Country> countries) {
		this.name = name;
		this.capital = capital;
		this.continent = continent;
		this.provinces = provinces;
		this.borderingCountries = countries;
	}
	
	public Country(String name, String capital, Continent continent) {
		this.name = name;
		this.capital = capital;
		this.continent = continent;
	}
	
	// Methods
	public String toString() {
		return "País: " + this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	public void setContinent(Continent continent) {
		this.continent = continent;
	}
	
	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}
	
	public void setBorderingCountries(List<Country> countries) {
		this.borderingCountries = countries;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCapital() {
		return this.capital;
	}
	
	public Continent getContinent() {
		return this.continent;
	}
	
	public List<Province> getProvinces() {
		return this.provinces;
	}
	
	public List<Country> getBorderingCountries() {
		return this.borderingCountries;
	}
	
	public void addProvince(Province province) {
		provinces.add(province);
	}
}
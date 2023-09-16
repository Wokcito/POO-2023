package tp_04;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class WorldMap {
	
	private List<Continent> continents = new ArrayList<Continent>();
	private List<Country> countries = new ArrayList<Country>();
	private List<Province> provinces = new ArrayList<Province>();
	
	// Constructor
	public WorldMap() {
		
		// Continents
		Continent America = new Continent("América");
		Continent Europa = new Continent("Europa");
		Continent Asia = new Continent("Asia");
		Continent Africa = new Continent("África");
		Continent Oceania = new Continent("Oceanía");
		Continent Antartida = new Continent("Antártida");
		
		this.continents.add(America);
		this.continents.add(Europa);
		this.continents.add(Asia);
		this.continents.add(Africa);
		this.continents.add(Oceania);
		this.continents.add(Antartida);
		
		// Countries
		Country Argentina = new Country("Argentina", "Buenos Aires", America);
		Country Uruguay = new Country("Uruguay", "Montevideo", America);
		Country Brasil = new Country("Brasil", "Rio de Janeiro", America);
		Country Chile = new Country("Chile", "Santiago de Chile", America);
		Country Paraguay = new Country("Paraguay", "Asunción", America);
		Country Bolivia = new Country("Bolivia", "La Paz", America);
		Country Espania = new Country("España", "Barcelona", Europa);
		Country Francia = new Country("Francia", "Paris", Europa);
		Country Italia = new Country("Italia", "Roma", Europa);
		Country Portugal = new Country("Portugal", "Listbon", Europa);
		
		America.addCountry(Argentina);
		America.addCountry(Bolivia);
		America.addCountry(Chile);
		America.addCountry(Uruguay);
		America.addCountry(Paraguay);
		America.addCountry(Brasil);
		Europa.addCountry(Espania);
		Europa.addCountry(Francia);
		Europa.addCountry(Italia);
		Europa.addCountry(Portugal);
		
		this.countries.add(Argentina);
		this.countries.add(Uruguay);
		this.countries.add(Brasil);
		this.countries.add(Chile);
		this.countries.add(Paraguay);
		this.countries.add(Bolivia);
		this.countries.add(Espania);
		this.countries.add(Francia);
		this.countries.add(Italia);
		this.countries.add(Portugal);
		
		// Bordering countries
		Argentina.setBorderingCountries(new ArrayList<Country>(Arrays.asList(Uruguay, Brasil, Chile, Paraguay, Bolivia)));
		Uruguay.setBorderingCountries(new ArrayList<Country>(Arrays.asList(Argentina, Brasil)));
		Brasil.setBorderingCountries(new ArrayList<Country>(Arrays.asList(Argentina, Uruguay, Paraguay, Bolivia)));
		Chile.setBorderingCountries(new ArrayList<Country>(Arrays.asList(Argentina, Bolivia)));
		Bolivia.setBorderingCountries(new ArrayList<Country>(Arrays.asList(Argentina, Paraguay, Brasil, Chile)));
		Paraguay.setBorderingCountries(new ArrayList<Country>(Arrays.asList(Argentina, Bolivia, Brasil)));
		
		Espania.setBorderingCountries(new ArrayList<Country>(Arrays.asList(Francia, Portugal)));
		Francia.setBorderingCountries(new ArrayList<Country>(Arrays.asList(Espania, Italia)));
		Italia.setBorderingCountries(new ArrayList<Country>(Arrays.asList(Francia)));
		Portugal.setBorderingCountries(new ArrayList<Country>(Arrays.asList(Espania)));
		
		// Provinces
		Province EntreRios = new Province("Entre Ríos", Argentina);
		Province BuenosAires = new Province("Buenos Aires", Argentina);
		Province SantaFe = new Province("Santa Fe", Argentina);
		Province Corrientes = new Province("Corrientes", Argentina);
		Province Cordoba = new Province("Córdoba", Argentina);
		Province Salto = new Province("Salto", Uruguay);
		Province Paysandu = new Province("Paysandú", Uruguay);
		Province Canelones = new Province("Canelones", Uruguay);
		Province Rocha = new Province("Rocha", Uruguay);
		Province Maldonado = new Province("Maldonado", Uruguay);
		
		Argentina.addProvince(EntreRios);
		Argentina.addProvince(BuenosAires);
		Argentina.addProvince(SantaFe);
		Argentina.addProvince(Corrientes);
		Argentina.addProvince(Cordoba);
		Uruguay.addProvince(Salto);
		Uruguay.addProvince(Paysandu);
		Uruguay.addProvince(Canelones);
		Uruguay.addProvince(Rocha);
		Uruguay.addProvince(Maldonado);
		
		this.provinces.add(EntreRios);
		this.provinces.add(BuenosAires);
		this.provinces.add(SantaFe);
		this.provinces.add(Corrientes);
		this.provinces.add(Cordoba);
		this.provinces.add(Salto);
		this.provinces.add(Paysandu);
		this.provinces.add(Canelones);
		this.provinces.add(Rocha);
		this.provinces.add(Maldonado);
	}
	
	public void getProvinces(String countryName) {
	    for (Country country : this.countries) {
	        if (country.getName().toLowerCase().equals(countryName.toLowerCase())) {
	            List<Province> provinces = country.getProvinces();
	            
	            for (Province province : provinces) {
	                System.out.println(province.getName());
	            }
	            
	            return;
	        }
	    }
	    
	    System.out.println("País no encontrado: " + countryName);
	}
	
	public void getCountries(String continentName) {
		for (Continent continent : this.continents) {
			if (continent.getName().toLowerCase().equals(continentName.toLowerCase())) {
				List<Country> countries = continent.getCountries();
				
				for (Country country : countries) {
					System.out.println(country.getName());
				}
				
				return;
			}
		}
		
		System.out.println("Continente no encontrado: " + continentName);
	}
	
	public void getBorderingCountries(String countryName) {
		for (Country country : this.countries) {
			if (country.getName().toLowerCase().equals(countryName.toLowerCase())) {
				List<Country> countries = country.getBorderingCountries();
				
				for (Country borderingCountry : countries) {
					System.out.println(borderingCountry.getName());
				}
				
				return;
			}
		}
		
		System.out.println("País no encontrado: " + countryName);
	}
}
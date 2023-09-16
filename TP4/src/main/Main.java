package tp_04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		WorldMap map = new WorldMap();
		
		Scanner scanner = new Scanner(System.in);

		// Get countries
		System.out.print("Ingrese el nombre de un CONTINENTE para obtener los países: ");
		String continentResponse = scanner.nextLine();
		map.getCountries(continentResponse);		
		
		System.out.println();
		
		// Get provinces
		System.out.print("Ingrese el nombre de un PAIS para obtener las provincias: ");
		String countryResponse = scanner.nextLine();
		map.getProvinces(countryResponse);
		
		System.out.println();
		
		// Get bordering countries
		System.out.print("Ingrese el nombre de un PAIS para obtener sus países limítrofes: ");
		String borderingResponse = scanner.nextLine();
		map.getBorderingCountries(borderingResponse);
		
		scanner.close();
	}
}
package models;

public enum ProductType {
	LACTEO("lacteo"),
	BEBIDA("bebida");
	
	private String name;
	
	private ProductType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

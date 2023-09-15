package model;

public class Product {
	private int id;
	private String name;
	private ProductType type;
	private Double price;
	private int stock;
	
	public Product(int id, String name, ProductType type, Double price, int stock) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int productId) {
		this.id = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductType getType() {
		return type;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}

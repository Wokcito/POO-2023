package model;

import dtos.ProductDTO;

public class PurchaseLine {
	private int id;
	private ProductDTO product;
	private int quantity;
	
	public PurchaseLine(int id, ProductDTO product, int quantity) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}
	
	public double getSubtotal() {
		return this.product.getPrice() * quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

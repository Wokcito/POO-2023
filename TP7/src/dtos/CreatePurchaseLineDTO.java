package dtos;

public class CreatePurchaseLineDTO {
	private ProductDTO product;
	private int quantity;
	
	public ProductDTO getProduct() {
		return this.product;
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

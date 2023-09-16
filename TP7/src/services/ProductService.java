package services;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

import dtos.CreateProductDTO;
import dtos.ProductDTO;
import models.Product;
import exceptions.CreateProductException;

public class ProductService {
	private List<Product> products = new ArrayList<Product>();
	private DecimalFormat priceDF = new DecimalFormat("#.##");
	
	/**
	 * Creates a new product an returns its id
	 * @param dataProduct
	 * @return New product's id
	 * @throws CreateProductException
	 */
	public int create(CreateProductDTO dataProduct) throws CreateProductException {
		
		// Validation
		List<String> messages = new ArrayList<String>();
		
		if (dataProduct.getName().length() < 2) {
			messages.add("El nombre debe contener más de dos caracteres");
		}
		
		if (dataProduct.getStock() < 0) {
			messages.add("El stock debe ser positivo");
		}
		
		if (dataProduct.getPrice() < 0) {
			messages.add("El precio debe ser positivo");
		}

		if (messages.size() > 0) {
			throw new CreateProductException(messages);
		}
		
		// If all is correct
		int productID = (int)Math.random() * (9999 - 1000 + 1) + 1000;
		
		Product product = new Product(
				productID,
				dataProduct.getName(),
				dataProduct.getType(),
				Double.parseDouble(priceDF.format(dataProduct.getPrice())),
				dataProduct.getStock()
		);
		
		this.products.add(product);
		return productID;
	}
	
	/**
	 * Returns the product with the given id if it's found
	 * @param id
	 * @return Product found or null
	 */
	public ProductDTO find(int id) {
		Product foundProduct = null;
		
		for (Product product : this.products) {
			if (product.getId() == id) {
				foundProduct = product;
			}
		}
		
		if (foundProduct == null) {
			return null;
		}
		
		ProductDTO product = new ProductDTO();
		product.setId(foundProduct.getId());
		product.setName(foundProduct.getName());
		product.setPrice(foundProduct.getPrice());
		product.setStock(foundProduct.getStock());
		product.setType(foundProduct.getType());
		
		return product;
	}
}

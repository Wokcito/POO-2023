package services;

import java.util.ArrayList;
import java.util.List;

import dtos.CreateProductDTO;
import dtos.ProductDTO;
import models.Product;
import exceptions.CreateProductException;
import mappers.ProductMapper;

public class ProductService {
	private List<Product> products = new ArrayList<Product>();
	
	/**
	 * Creates a new product an returns its id
	 * @param dataProduct
	 * @return New product's id
	 * @throws CreateProductException
	 */
	public int create(CreateProductDTO productData) throws CreateProductException {
		
		// Validation
		List<String> messages = new ArrayList<String>();
		
		if (productData.getName().length() < 2) {
			messages.add("El nombre debe contener más de dos caracteres");
		}
		
		if (productData.getStock() < 0) {
			messages.add("El stock debe ser positivo");
		}
		
		if (productData.getPrice() < 0) {
			messages.add("El precio debe ser positivo");
		}

		if (messages.size() > 0) {
			throw new CreateProductException(messages);
		}
		
		// If all is correct
		int productId = (int)Math.random() * (9999 - 1000 + 1) + 1000;
		
		Product product = ProductMapper.dtoToProduct(productData, productId);
		
		this.products.add(product);
		return productId;
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
		
		return ProductMapper.productToDTO(foundProduct);
	}
}

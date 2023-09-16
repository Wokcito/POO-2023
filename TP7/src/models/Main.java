package models;

import exceptions.CreateProductException;
import services.ProductService;
import dtos.ProductDTO;

public class Main {

	public static void main(String[] args) throws CreateProductException {
		ProductDTO product = new ProductDTO();
		product.setName("a");
		product.setType(ProductType.BEBIDA);
		product.setPrice(-10.00);
		product.setStock(-10);
		
		ProductService create = new ProductService();
		
		create.create(product);
	}

}

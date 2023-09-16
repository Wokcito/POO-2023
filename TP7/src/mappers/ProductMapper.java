package mappers;

import dtos.ProductDTO;

import java.text.DecimalFormat;

import dtos.CreateProductDTO;
import models.Product;

public class ProductMapper {
	
	public static ProductDTO productToDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setStock(product.getStock());
		productDTO.setType(product.getType());
		
		return productDTO;
	}
	
	public static Product dtoToProduct(CreateProductDTO productDTO, int id) {
		return new Product(
				id,
				productDTO.getName(),
				productDTO.getType(),
				Double.parseDouble(new DecimalFormat("#.##").format(productDTO.getPrice())),
				productDTO.getStock()
		);
	}
}

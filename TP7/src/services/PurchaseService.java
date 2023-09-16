package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dtos.ClientDTO;
import dtos.CreatePurchaseDTO;
import dtos.CreatePurchaseLineDTO;
import dtos.ProductDTO;
import dtos.PurchaseDTO;
import dtos.PurchaseLineDTO;
import exceptions.CreatePurchaseException;
import models.Purchase;
import models.PurchaseLine;

public class PurchaseService {
	private ClientService clientService;
	private ProductService productService;
	private List<Purchase> purchases = new ArrayList<Purchase>();
	
	/**
	 * @param clientService
	 * @param productService
	 */
	public PurchaseService(ClientService clientService, ProductService productService) {
		this.clientService = clientService;
		this.productService = productService;
	}
	
	/**
	 * Creates a new purchase and returns its id
	 * @param purchaseData
	 * @return New purchase's id
	 * @throws CreatePurchaseException
	 */
	public int create(CreatePurchaseDTO purchaseData) throws CreatePurchaseException {
		ClientDTO clientData = this.clientService.find(purchaseData.getClientId());
		List<PurchaseLine> purchaseLines = new ArrayList<PurchaseLine>();
		List<String> errorMessages = new ArrayList<String>();
		
		// Validation
		if (clientData == null) {
			errorMessages.add("El cliente no existe");
		}
		
		for (CreatePurchaseLineDTO purchaseLineData : purchaseData.getPurchaseLines()) {
			ProductDTO product = productService.find(purchaseLineData.getProduct().getId());
			
			// Checks if the product exists
			if (product == null) {
				errorMessages.add("El producto no existe");
			}
			
			int quantity = purchaseLineData.getQuantity();

			// Check that the quantity is higher than zero
			if (quantity <= 0) {
				errorMessages.add("La cantidad debe ser positiva y mayor a cero");
			}
			
			// Checks if the there are enough stock
			int stock = product.getStock();
			
			if (quantity > stock) {
				errorMessages.add("No hay suficiente stock del producto " + product.getName() + ". El stock es de: " + stock);
			}
			
			// If all is correct then the purchase line is created
			int purchaseLineId = (int)Math.random() * (9999 - 1000 + 1) + 1000;
			
			PurchaseLine purchaseLine = new PurchaseLine(
					purchaseLineId,
					product,
					quantity
			);
			
			purchaseLines.add(purchaseLine);
		}
		
		// Check if there is an error
		if (errorMessages.size() > 0) {
			throw new CreatePurchaseException(errorMessages);
		}
		
		// If all is correct
		int purchaseId = (int)Math.random() * (9999 - 1000 + 1) + 1000;
		
		Purchase purchase = new Purchase(
				purchaseId,
				clientData.getId(),
				purchaseLines,
				purchaseData.getPromotion(),
				new Date()
		);

		purchases.add(purchase);
		return purchaseId;
	}
	
	/**
	 * Returns the purchase with the given id if it's found
	 * @param id
	 * @return Purchase found or null
	 */
	public PurchaseDTO find(int id) {
		Purchase foundPurchase = null;
		
		for (Purchase purchase : this.purchases) {
			if (purchase.getId() == id) {
				foundPurchase = purchase;
			}
		}
		
		if (foundPurchase == null) {
			return null;
		}
		
		PurchaseDTO purchase = new PurchaseDTO();
		purchase.setId(foundPurchase.getId());
		purchase.setClientId(foundPurchase.getClientID());
		purchase.setPromotion(foundPurchase.getPromotion());
		
		List<PurchaseLineDTO> purchaseLines = new ArrayList<PurchaseLineDTO>();
		
		for (PurchaseLine purchaseLineData : foundPurchase.getPurchaseLines()) {
			PurchaseLineDTO purchaseLine = new PurchaseLineDTO();
			purchaseLine.setId(purchaseLineData.getId());
			purchaseLine.setProduct(purchaseLineData.getProduct());
			purchaseLine.setQuantity(purchaseLineData.getQuantity());
			
			purchaseLines.add(purchaseLine);
		}
		
		purchase.setPurchaseLines(purchaseLines);
		
		return purchase;
	}
}

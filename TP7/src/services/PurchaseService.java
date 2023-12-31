package services;

import java.util.ArrayList;
import java.util.List;

import dtos.ClientDTO;
import dtos.CreatePurchaseDTO;
import dtos.CreatePurchaseLineDTO;
import dtos.ProductDTO;
import dtos.PurchaseDTO;
import exceptions.CreatePurchaseException;
import mappers.PurchaseMapper;
import models.Purchase;
import models.PurchaseLine;

public class PurchaseService {
	private static PurchaseService purchaseService;
	private ClientService clientService;
	private ProductService productService;
	private List<Purchase> purchases = new ArrayList<Purchase>();
	
	/**
	 * @param clientService
	 * @param productService
	 */
	private PurchaseService(ClientService clientService, ProductService productService) {
		this.clientService = clientService;
		this.productService = productService;
	}
	
	/**
	 * Returns a single instance of PurchaseService
	 * @param clientService
	 * @param productService
	 * @return PurchaseService's instance
	 */
	public static PurchaseService getInstance(ClientService clientService, ProductService productService) {
		if (purchaseService == null) {
			purchaseService = new PurchaseService(clientService, productService);
		}
		
		return purchaseService;
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
		
		Purchase purchase = PurchaseMapper.dtoToPurchase(purchaseId, clientData.getId(), purchaseLines, purchaseData.getPromotion());

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
		
		return PurchaseMapper.purchaseToDTO(foundPurchase);
	}
}

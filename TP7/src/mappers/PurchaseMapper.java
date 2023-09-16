package mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dtos.PurchaseDTO;
import dtos.PurchaseLineDTO;
import models.Purchase;
import models.PurchaseLine;
import promotions.IPromotion;

public class PurchaseMapper {
	public static PurchaseDTO purchaseToDTO(Purchase purchase) {
		PurchaseDTO purchaseDTO = new PurchaseDTO();
		
		purchaseDTO.setId(purchase.getId());
		purchaseDTO.setClientId(purchase.getClientID());
		purchaseDTO.setPromotion(purchase.getPromotion());
		
		List<PurchaseLineDTO> purchaseLines = new ArrayList<PurchaseLineDTO>();
		
		for (PurchaseLine purchaseLineData : purchase.getPurchaseLines()) {
			PurchaseLineDTO purchaseLine = new PurchaseLineDTO();
			
			purchaseLine.setId(purchaseLineData.getId());
			purchaseLine.setProduct(purchaseLineData.getProduct());
			purchaseLine.setQuantity(purchaseLineData.getQuantity());
			
			purchaseLines.add(purchaseLine);
		}
		
		purchaseDTO.setPurchaseLines(purchaseLines);
		
		return purchaseDTO;
	}
	
	public static Purchase dtoToPurchase(int id, int clientId, List<PurchaseLine> purchaseLines, IPromotion promotion) {
		return new Purchase(
				id,
				clientId,
				purchaseLines,
				promotion,
				new Date()
		);
	}
}

package dtos;

import java.util.List;
import promotions.IPromotion;

public class CreatePurchaseDTO {
	private int clientId;
	private List<PurchaseLineDTO> purchaseLines;
	private IPromotion promotion;

	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public IPromotion getPromotion() {
		return promotion;
	}
	public void setPromotion(IPromotion promotion) {
		this.promotion = promotion;
	}
	public List<PurchaseLineDTO> getPurchaseLines() {
		return purchaseLines;
	}
	public void setPurchaseLines(List<PurchaseLineDTO> purchaseLines) {
		this.purchaseLines = purchaseLines;
	}
}

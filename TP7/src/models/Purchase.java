package model;

import java.util.Date;
import java.util.List;

import promotions.IPromotion;

public class Purchase {
	private int id;
	private int clientID;
	private Date date;
	private List<PurchaseLine> purchaseLines;
	private IPromotion promotion;
	
	public Purchase(int id, int clientID, List<PurchaseLine> purchaseLines, IPromotion promotion, Date date) {
		this.id = id;
		this.clientID = clientID;
		this.date = date;
		this.purchaseLines = purchaseLines;
		this.promotion = promotion;
	}
	
	public double getTotal() {
		double total = 0;
		int count = 0;
		
		while (count < purchaseLines.size()) {
			total += purchaseLines.get(count).getSubtotal();
			count++;
		}
		
		return this.promotion.getDiscount(total);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public List<PurchaseLine> getPurchaseLines() {
		return purchaseLines;
	}
	public void setPurchaseLines(List<PurchaseLine> purchaseLines) {
		this.purchaseLines = purchaseLines;
	}
	public IPromotion getPromotion() {
		return promotion;
	}
	public void setPromotion(IPromotion promotion) {
		this.promotion = promotion;
	}
}

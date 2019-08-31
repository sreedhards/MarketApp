package model;

public class TopBook {
	private String symbol;
	private int bidPrice;
	private int bidQuantity;
	private int offerPrice;
	private int offerQuantity;
	
	public TopBook() {
		super();		
	}
	
	public TopBook(String symbol, int bidPrice, int bidQuantity, int offerPrice, int offerQuantity) {
		super();
		this.symbol = symbol;
		this.bidPrice = bidPrice;
		this.bidQuantity = bidQuantity;
		this.offerPrice = offerPrice;
		this.offerQuantity = offerQuantity;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	public int getbidQuantity() {
		return bidQuantity;
	}
	public void setbidQuantity(int bidQuantity) {
		this.bidQuantity = bidQuantity;
	}
	public int getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(int offerPrice) {
		this.offerPrice = offerPrice;
	}
	public int getofferQuantity() {
		return offerQuantity;
	}
	public void setofferQuantity(int offerQuantity) {
		this.offerQuantity = offerQuantity;
	}

	public boolean validData() {
		// TODO Auto-generated method stub
		if( symbol != null && !symbol.isEmpty()
				&& bidPrice > 0  && bidQuantity > 0
				&& offerPrice > 0  && offerQuantity > 0)
			return true;
		 
		return false;
	}

}

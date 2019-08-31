package model;

public class OrderBook {
	
	private int orderid;	
	private int price;
	private int quantity;
	private String symbol;
	private String side;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public OrderBook() {
		super();
	
	}

	public OrderBook(int orderid, String symbol, int price, int quantity, String side) {
		super();
		this.orderid = orderid;
		this.symbol = symbol;
		this.price = price;
		this.quantity = quantity;
		this.side = side;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public boolean validData() {
		// TODO Auto-generated method stub
		if(orderid > 0 && type != null )
			return true;
		
		return false;
	}
	
	
	

}

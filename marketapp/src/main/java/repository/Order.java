package repository;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


public class Order {
	int price;
	int quantity;
	
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
	public Order(int price, int quantity) {
		super();
		this.price = price;
		this.quantity = quantity;
	}
	public Order() {
		super();
		}
	
	
}

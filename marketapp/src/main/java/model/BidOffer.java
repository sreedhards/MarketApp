package model;

import java.util.ArrayList;
import java.util.List;

import repository.Order;



public class BidOffer
{
	 List<Order> bid;
	 List<Order> offer;
	
	public BidOffer(){
		bid = new ArrayList<>();
		offer = new ArrayList<>();
	}
	
	public List<Order> getBid() {
		return bid;
	}
	public void setBid(List<Order> bid) {
		this.bid = bid;
	}
	public List<Order> getOffer() {
		return offer;
	}
	public void setOffer(List<Order> offer) {
		this.offer = offer;
	}
	
	public void addBid(Order order)
	{
		bid.add(order);
		
	}
	public void addOffer(Order order)
	{
		offer.add(order);
		
	}
	
}

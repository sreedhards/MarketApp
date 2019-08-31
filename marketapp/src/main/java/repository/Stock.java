package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.BidOffer;

import java.util.TreeMap;

/**
 * @author srds
 *
 */

public class Stock {
	private String symbol;
	private Map<Integer,Integer> Bids;
	private Map<Integer,Integer> Offers;
	private Map<Integer,Order> BuyOrders;
	private Map<Integer,Order> SellOrders;
	
	
	
	public Stock(String name) {
		symbol = name;
		Bids = new TreeMap<>(Collections.reverseOrder());
		Offers = new TreeMap<>();
		BuyOrders = new TreeMap<>();
		SellOrders = new TreeMap<>();
		
	}



	public String getSymbol() {
		return symbol;
	}



	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}



	public Map<Integer, Integer> getBids() {
		return Bids;
	}



	public void setBids(Integer bidPrice, Integer bidQuantity) {
		
		if(Bids.containsKey(bidPrice)) {
			if(Bids.get(bidPrice)+bidQuantity <=0)
				Bids.remove(bidPrice);
			else
				Bids.put(bidPrice, Bids.get(bidPrice)+bidQuantity);
			
		}
		else
			Bids.put(bidPrice, bidQuantity);
		
	}



	public Map<Integer, Integer> getOffers() {
		return Offers;
	}



	public void setOffers(Integer Price, Integer Quantity) {
		if(Offers.containsKey(Price)) {
			if(Offers.get(Price)+Quantity <=0)
				Offers.remove(Price);
			else
				Offers.put(Price, Offers.get(Price)+Quantity);
		}
		else
			Offers.put(Price, Quantity);
		
	}



	public Map<Integer, Order> getBuyOrders() {
		return BuyOrders;
	}



	public void setOrders(int price, Integer Quantity, Integer orderId ,String side) {
		Map<Integer,Order> mapOrder;
		if(side.equalsIgnoreCase("buy"))
		{
			mapOrder = BuyOrders;
		}
		else
		{
			mapOrder = SellOrders;
		}
		
		if(mapOrder.containsKey(orderId)) {
			Order o = BuyOrders.get(orderId);
				o.quantity = Quantity;
				o.price = price;
				
				mapOrder.put(orderId,o);
		}
		else
		{
			Order o = new Order();			
			o.quantity = Quantity;
			o.price = price;
			
			mapOrder.put(orderId,o);
		}
		
		if(side.equalsIgnoreCase("buy"))
		{
			setBids(price, Quantity);
		}
		else
		{
			setOffers(price, Quantity);
		}
		 		
	}
	
	public void modifyOrder(Integer orderId, Integer quantity) {
		if(BuyOrders.containsKey(orderId)) {
			Order o = BuyOrders.get(orderId);
			Integer diff =  quantity - o.quantity ;				
			o.quantity = quantity;	
			BuyOrders.put(orderId,o);
			setBids(o.price, diff);
		}
		else if(SellOrders.containsKey(orderId)) {
			Order o = SellOrders.get(orderId);
			Integer diff =  quantity - o.quantity ;				
			o.quantity = quantity;	
			SellOrders.put(orderId,o);
			setOffers(o.price, diff);
		}
	}
	
	public void cancelOrder(Integer orderid) {
		if(BuyOrders.containsKey(orderid)) {
			Order o = BuyOrders.get(orderid);
			Integer diff =   -o.quantity ;				
				
			BuyOrders.remove(orderid);
			setBids(o.price, diff);
		} else if(SellOrders.containsKey(orderid)) {
			Order o = SellOrders.get(orderid);
			Integer diff =   -o.quantity ;				
				
			SellOrders.remove(orderid);
			setOffers(o.price, diff);
		}
	}

	public Map<Integer, Order> getSellOrders() {
		return SellOrders;
	}

/*	public void setSellOrders(Integer Price, Integer Quantity, Integer orderId ) {
		if(SellOrders.containsKey(orderId)) {
			Order o = SellOrders.get(orderId);
				o.quantity = Quantity;
				o.price = Price;
				
				SellOrders.put(orderId,o);
		}
		else
		{
			Order o = new Order();			
			o.quantity = Quantity;
			o.price = Price;
			
			SellOrders.put(orderId,o);
		}
		setOffers(Price, Quantity);
	}
	
	public void modifySellOrder(Integer orderId, Integer quantity) {
		if(SellOrders.containsKey(orderId)) {
			Order o = SellOrders.get(orderId);
			Integer diff =  quantity - o.quantity ;				
			o.quantity = quantity;	
			SellOrders.put(orderId,o);
			setOffers(o.price, diff);
		}				
	}


	public void cancelSellOrder(Integer orderid) {
		if(SellOrders.containsKey(orderid)) {
			Order o = SellOrders.get(orderid);
			Integer diff =   -o.quantity ;				
				
			SellOrders.remove(orderid);
			setOffers(o.price, diff);
		}
	}
*/
	public BidOffer getTopBids(int size)
	{
		BidOffer toplist = new BidOffer();
		int bidSize = size;
		int offerSize = size;
		
		int i =0;
		
		if (bidSize > Bids.size())
			bidSize = Bids.size();
		
		for (Integer bid : Bids.keySet())  
        { 
			if(i<bidSize) {
            
				Order o = new Order();  
				// search  for value 
            Integer quantity = Bids.get(bid);
            o.price = bid;
            o.quantity= quantity;
            toplist.addBid(o);
            System.out.println("Key = " + bid + ", Value = " + quantity);
			}
			else
				break;
			i++;
        } 

		i = 0;
		if (offerSize > Offers.size())
			offerSize = Offers.size();
	
		for (Integer offer : Offers.keySet())  
        { 
			if(i<offerSize) {
            
				Order o = new Order();  
				// search  for value 
            Integer quantity = Offers.get(offer);
            o.price = offer;
            o.quantity= quantity;
            toplist.addOffer(o);
            System.out.println("Key = " + offer + ", Value = " + quantity);
			}
			else
				break;
			i++;
        }				
		
		return toplist;
	}
	
}

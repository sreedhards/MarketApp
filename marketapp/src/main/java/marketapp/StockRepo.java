package marketapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import model.BidOffer;
import model.OrderBook;
import model.TopBook;
import repository.Stock;

@Component
public class StockRepo {

	private static Map<String,Stock> stocks = new HashMap<>();
	private static Map<Integer,String> OrderSymbolMap = new HashMap<>();
	
	public Stock getStock(String symbol) {
		if(stocks.containsKey(symbol)) {
			return stocks.get(symbol);
		}
		
		return null;
	}
	
	public void addOrderBook(OrderBook orderbook) {
		
		if(!orderbook.validData())
			return;
		
		if(orderbook.getType().equalsIgnoreCase("new")) {
				Stock s = getStock(orderbook.getSymbol());
				
				if(s == null) {
					 s = new Stock(orderbook.getSymbol());
					 stocks.put(orderbook.getSymbol(),s);
				}
				
				s.setOrders(orderbook.getPrice(), orderbook.getQuantity(), orderbook.getOrderid(),orderbook.getSide());
				
				OrderSymbolMap.put(orderbook.getOrderid(), orderbook.getSymbol());
				
	 
		}else if(orderbook.getType().equalsIgnoreCase("modify") || orderbook.getType().equalsIgnoreCase("cancel")) {
				
			if(OrderSymbolMap.containsKey(orderbook.getOrderid())) {
				String symbol =	OrderSymbolMap.get(orderbook.getOrderid());
				Stock s = getStock(symbol);
				if(orderbook.getType().equalsIgnoreCase("modify"))
					s.modifyOrder(orderbook.getOrderid(), orderbook.getQuantity());
				else
					s.cancelOrder(orderbook.getOrderid());
				
			}
		}
	}
	
	
	public void addTopBook(TopBook topbook) {
		
		if(!topbook.validData())
			return;
		
		Stock s = getStock(topbook.getSymbol());
		
		if(s == null) {
			 s = new Stock(topbook.getSymbol());
			 stocks.put(topbook.getSymbol(),s);
		}
			
		s.setBids(topbook.getBidPrice(),topbook.getbidQuantity());
		s.setOffers(topbook.getOfferPrice(), topbook.getofferQuantity());
		
	}
	
	public BidOffer getTopBids(String symbol)
	{
		Stock s = getStock(symbol);
		if(s != null) 
			return s.getTopBids(5);
		
		return null;
	}
	
}

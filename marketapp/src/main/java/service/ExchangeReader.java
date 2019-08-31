package service;
import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import marketapp.StockRepo;
import model.OrderBook;
import model.TopBook;

public class ExchangeReader {
	
		
	private String path;
	private String exchangeName;
	private String type;
	private StockRepo stockService;
	public ExchangeReader(String exchangeName, String path, String orderType, StockRepo stockService ) {
		super();
		this.exchangeName = exchangeName;
		this.path = path;
		this.type = orderType;
		this.stockService = stockService;
	}
	
	
	private class ReaderRunnable implements Runnable {
		
		private String path;
		private String exchangeName;
		
		public ReaderRunnable(String path, String exchangeName) {
			super();
			this.path = path;
			this.exchangeName = exchangeName;
		}

		  
        public void run() 
        { 
            System.out.println(Thread.currentThread().getName() 
                             + ", executing run() method!" + exchangeName); 
            
            	 
            try (InputStream in = this.getClass().getClassLoader()
			           .getResourceAsStream(path)) {
                JsonFactory jf = new JsonFactory();
                JsonParser jp = (JsonParser) jf.createParser(in);
                jp.setCodec(new ObjectMapper());
                jp.nextToken();
                while (jp.hasCurrentToken()) {
                	
                	try {
						if(type.equalsIgnoreCase("topbook")) {
							TopBook topbook = jp.readValueAs(TopBook.class);
							System.out.println("TOP symbol "+topbook.getSymbol());
							stockService.addTopBook(topbook);							
							
						}
						else {
							
							OrderBook orderbook = jp.readValueAs(OrderBook.class);
							System.out.println("ORB symbol "+orderbook.getSymbol());
							stockService.addOrderBook(orderbook);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
                	
                    jp.nextToken();
                    
                }
            }
         			 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
	}
	 
		public  void StartReader() 
		{
			Thread t1 = new Thread(new ReaderRunnable(this.path,this.exchangeName)); 
	        t1.start(); 
		
		}
	
}

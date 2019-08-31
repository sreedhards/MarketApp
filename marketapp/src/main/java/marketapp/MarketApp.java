package marketapp;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import service.StockReaderService;

@SpringBootApplication
public class MarketApp {

	
	private static StockReaderService stockReaderService;
	public static void main(String[] args) {
		SpringApplication.run(MarketApp.class, args);
		
		try {
			if(stockReaderService == null)
				stockReaderService = new StockReaderService();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

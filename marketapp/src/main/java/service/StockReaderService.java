package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;

import marketapp.StockRepo;

@Component
public class StockReaderService {
	
	static String exhangeNames[] = new String[]{"NSE","BSE"};
	static String path[] = new String[]{"nse.json","bse.json"};
	static String type[] = new String[]{"orderbook","topbook"};

	private StockRepo stockRepo;
	
	public StockReaderService() throws IOException {
		super();
		stockRepo = new StockRepo();		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		this.Start();

	}


	public  void Start() throws IOException 
	{
		List<ExchangeReader> l = new ArrayList<ExchangeReader>();			 

		for(int i=0; i< exhangeNames.length;i++)				
		{
			ExchangeReader er = new ExchangeReader(exhangeNames[i],path[i],type[i],stockRepo);
			l.add(er);
			er.StartReader();
		}
	}


}

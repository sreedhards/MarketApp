package marketapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.BidOffer;

@RestController
@RequestMapping("/api")
public class ApiController {

	
	
	StockRepo stockRepo;
	@Autowired
	public ApiController(StockRepo stockRepo) throws IOException {
		super();
				this.stockRepo = stockRepo;
		
	}

	
	
	@GetMapping("/topofthebook/{symbol}")
	public BidOffer getTopOfTheBook(@PathVariable(value = "symbol") String symbol) throws InterruptedException, ExecutionException{
			return  stockRepo.getTopBids(symbol);
	}


}

/**
 * 
 */
package marketapp;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import model.TopBook;
import repository.Stock;

/**
 * @author srds
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class StockRepoTest {
	@Mock
	private Map<Integer, String> orderSymbolMap;

	@Mock
	private Map<String, Stock> stocks;
	@InjectMocks
	private StockRepo stockRepo;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link marketapp.StockRepo#getStock(java.lang.String)}.
	 */
	@Test
	public final void testGetStock() throws Exception {
		// TODO
		//throw new RuntimeException("not yet implemented");
		TopBook topbook = new TopBook("TATA",100,20,120,30);
		stockRepo = new StockRepo(); 
		
		stockRepo.addTopBook(topbook);
		
		Stock s = stockRepo.getStock("TATA");
		assertEquals("TATA", s.getSymbol());
		
	}

	/**
	 * Test method for {@link marketapp.StockRepo#addOrderBook(model.OrderBook)}.
	 */
	@Test
	public final void testAddOrderBook() throws Exception {
		// TODO
		
	}

	/**
	 * Test method for {@link marketapp.StockRepo#addTopBook(model.TopBook)}.
	 */
	@Test
	public final void testAddTopBook() throws Exception {
		// TODO
		
	}

	/**
	 * Test method for {@link marketapp.StockRepo#getTopBids(java.lang.String)}.
	 */
	@Test
	public final void testGetTopBids() throws Exception {
		// TODO
		
	}

}

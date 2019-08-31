/**
 * 
 */
package marketapp;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import model.BidOffer;
import model.TopBook;

/**
 * @author srds
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ApiControllerTest {
	@Mock
	private StockRepo stockRepo;
	@InjectMocks
	private ApiController apiController;

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
	 * Test method for {@link marketapp.ApiController#ApiController(marketapp.StockRepo)}.
	 */
	@Test
	public final void testApiController() throws Exception {
		// TODO
		//throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link marketapp.ApiController#getTopOfTheBook(java.lang.String)}.
	 */
	@Test
	public final void testGetTopOfTheBook() throws Exception {
		// TODO
		TopBook topbook = new TopBook("TATA",100,20,120,30);
		
		stockRepo = new StockRepo(); 
		
		stockRepo.addTopBook(topbook);
		BidOffer b = stockRepo.getTopBids("TATA");
		System.out.println(b.getBid());
		assertEquals(100, b.getBid().get(0).getPrice());
		
	}

}

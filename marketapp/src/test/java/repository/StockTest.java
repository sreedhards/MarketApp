/**
 * 
 */
package repository;

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

/**
 * @author srds
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class StockTest {
	@Mock
	private Map<Integer, Integer> bids;

	@Mock
	private Map<Integer, Order> buyOrders;

	@Mock
	private String name;

	@Mock
	private Map<Integer, Integer> offers;

	@Mock
	private Map<Integer, Order> sellOrders;

	@Mock
	private String symbol;
	@InjectMocks
	private Stock stock;

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
	 * Test method for {@link repository.Stock#Stock(java.lang.String)}.
	 */
	@Test
	public final void testStock() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link repository.Stock#getBids()}.
	 */
	@Test
	public final void testGetBids() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link repository.Stock#setBids(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public final void testSetBids() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link repository.Stock#getOffers()}.
	 */
	@Test
	public final void testGetOffers() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link repository.Stock#setOffers(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public final void testSetOffers() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link repository.Stock#getBuyOrders()}.
	 */
	@Test
	public final void testGetBuyOrders() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link repository.Stock#setOrders(int, java.lang.Integer, java.lang.Integer, java.lang.String)}.
	 */
	@Test
	public final void testSetOrders() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link repository.Stock#modifyOrder(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	public final void testModifyOrder() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link repository.Stock#cancelOrder(java.lang.Integer)}.
	 */
	@Test
	public final void testCancelOrder() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link repository.Stock#getSellOrders()}.
	 */
	@Test
	public final void testGetSellOrders() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

	/**
	 * Test method for {@link repository.Stock#getTopBids(int)}.
	 */
	@Test
	public final void testGetTopBids() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

}

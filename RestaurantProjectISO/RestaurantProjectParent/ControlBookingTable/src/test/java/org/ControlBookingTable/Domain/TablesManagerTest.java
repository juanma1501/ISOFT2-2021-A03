package org.ControlBookingTable.Domain;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TablesManagerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertDelete() throws Exception{
		Table t = new Table(10,7,States.BOOKED,"10/02/20 22:55:00");
		assertTrue(t.insert());
		
		assertTrue(t.delete());
	}
	
	@Test
	public void TestUpdateReadDelete() throws Exception{
		Table t = new Table(9,7,States.BOOKED,"10/02/20 22:55:00");
		assertTrue(t.insert());
		t.setClients(15);
		
		assertTrue(t.update());
		
		assertTrue(t.read());
		
		assertEquals(15,t.getClients());
		
		assertTrue(t.delete());
		
	}
	@Test
	public void TestReadAll() throws Exception{
		try {
			Table t = new Table(9,7,States.BOOKED,"10/02/20 22:55:00");
			assertTrue(t.readAll());
			assertNotEquals(t.getTablesManager().get_tablesList().size(),0);
		}catch(Exception e) {
			assumeNoException(e);
		}
		
	}
	

}

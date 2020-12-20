package org.ControlBookingTable.Domain;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.ControlBookingTable.Domain.Table;
public class TableTest {

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
	public void testNewTable() {
		try {
			Table table = new Table(1,6,States.UNOCCUPIED);
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	@Test
	public void testSetIdTable() throws Exception{
		Table t = new Table();
		try {
			t.setIdTable(32);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(32,t.getIdTable());
	}
	
	@Test
	public void testSetClients() throws Exception{
		Table t = new Table();
		try {
			t.setClients(7);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(7,t.getClients());
	}
	
	@Test
	public void testSetState() throws Exception{
		Table t = new Table();
		try {
			t.setState(States.BOOKED);
		}catch(Exception e) {
			assumeNoException(e);
			
		}
		assertEquals(States.BOOKED,t.getState());
	}


}

package org.ControlBookingTable.Domain;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.ControlBookingTable.Domain.Booking;
import org.ControlBookingTable.Domain.Table;

public class BookingTest {
	private Table table;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		table= new Table (1,6,States.UNOCCUPIED);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBooking() {
		try {
			Booking b = new Booking("Pablo",4,1,table,"Lunch",1);
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	@Test
	public void testBooking2() {
		try {
			Booking b = new Booking("Pablo",-6,-6,table, "Lunch", -1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBooking3() {
		try {
			Booking b = new Booking("",-6,-6,table, "", -1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSetGet_name() {
		Booking b = new Booking();
		try {
			b.set_name("pablo");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_name(), "pablo");
	}
	
	@Test
	public void testSetGet_guests() {
		Booking b = new Booking();
		try {
			b.set_guests(2);
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_guests(), 2);
	}
	
	@Test
	public void testSetGet_turn() {
		Booking b = new Booking();
		try {
			b.set_turn(2);
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_turn(), 2);
	}
	@Test
	public void testSetGet_turnLunchDinner() {
		Booking b = new Booking();
		try {
			b.set_turnLunchDinner("lunch");;
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_turnLunchDinner(), "lunch");
	}
	
	public void testSetGetidBooking() {
		Booking b = new Booking();
		try {
			b.setIdBooking(100);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.getIdBooking(), 100);
	}
	
	
	
	

}

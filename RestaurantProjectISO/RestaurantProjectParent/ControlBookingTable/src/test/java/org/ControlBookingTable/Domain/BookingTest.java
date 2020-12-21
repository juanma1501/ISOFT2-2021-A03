package org.ControlBookingTable.Domain;

import static org.junit.Assert.*;

import static org.junit.Assume.assumeNoException;

import java.util.Date;

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
		try {
			table = new Table(1,6,States.UNOCCUPIED, "23/10/18 23:00:00");
		}catch(Exception e) {
			assumeNoException(e);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBooking() throws Exception{
		try {
			Booking b = new Booking("Pablo",4,1,table,"Lunch",1);
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	@Test
	public void testBooking2() throws Exception{
		try {
			Booking b = new Booking("Pablo",-6,-6,table, "Lunch", -1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBooking3() throws Exception{
		try {
			Booking b = new Booking("",-6,-6,table, "", -1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSetGet_name() throws Exception{
		Booking b = new Booking();
		try {
			b.set_name("pablo");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_name(), "pablo");
	}
	
	@Test
	public void testSetGet_guests() throws Exception{
		Booking b = new Booking();
		try {
			b.set_guests(2);
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_guests(), 2);
	}
	
	@Test
	public void testSetGet_turn() throws Exception{
		Booking b = new Booking();
		try {
			b.set_turn(2);
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_turn(), 2);
	}
	@Test
	public void testSetGet_turnLunchDinner() throws Exception{
		Booking b = new Booking();
		try {
			b.set_turnLunchDinner("lunch");;
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_turnLunchDinner(), "lunch");
	}
	
	public void testSetGetidBooking() throws Exception{
		Booking b = new Booking();
		try {
			b.setIdBooking(100);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.getIdBooking(), 100);
	}
	
	
	
	

}

package org.ControlBookingTable.Domain;

import static org.junit.Assert.*;

import static org.junit.Assume.assumeNoException;

<<<<<<< HEAD
=======

>>>>>>> master
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
			table = new Table(1, 6, States.UNOCCUPIED, "23/10/18 23:00:00");
		} catch (Exception e) {
			assumeNoException(e);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBooking() throws Exception {
		try {
<<<<<<< HEAD
			Booking b = new Booking("Pablo", -4, -7, table, "Lunch", -5);
		} catch (Exception e) {
=======
			Booking b = new Booking("Pablo",-4,-7,table,"Lunch",-5);
		}catch(Exception e) {
>>>>>>> master
			assumeNoException(e);
		}
	}

	@Test
	public void testBooking2() throws Exception {
		try {
			Booking b = new Booking("", 4, 2, table, "Dinner", 5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBooking3() throws Exception {
		try {
			Booking b = new Booking("Pablo", 0, 2, table, "", 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBooking4() throws Exception {
		try {
			Booking b = new Booking("", 4, 1, table, "Dinner", -5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBooking5() throws Exception {
		try {
			Booking b = new Booking("Pablo", -4, -7, table, "Lunch", 5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBooking6() throws Exception {
		try {
			Booking b = new Booking("Pablo", 0, -7, table, "Dinner", -5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBooking7() throws Exception {
		try {
			Booking b = new Booking("Pablo", 4, 2, table, "Lunch", 5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBooking8() throws Exception {
		try {
			Booking b = new Booking("", -4, 1, table, "Dinner", -5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBooking9() throws Exception {
		try {
<<<<<<< HEAD
			Booking b = new Booking("Pablo", 4, 1, table, "Lunch", 5);

		} catch (Exception e) {
=======
			Booking b = new Booking("",4,2,table, "Dinner", 5);
			
		}catch(Exception e) {
>>>>>>> master
			e.printStackTrace();
		}
	}

	@Test
	public void testBooking10() throws Exception {
		try {
<<<<<<< HEAD
			Booking b = new Booking("Pablo", -4, -7, table, "Lunch", 0);

		} catch (Exception e) {
=======
			Booking b = new Booking("Pablo",0,2,table, "", 0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBooking4() throws Exception{
		try {
			Booking b = new Booking("",4,1,table, "Dinner", -5);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBooking5() throws Exception{
		try {
			Booking b = new Booking("Pablo",-4,-7,table, "Lunch", 5);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBooking6() throws Exception{
		try {
			Booking b = new Booking("Pablo",0,-7,table, "Dinner", -5);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBooking7() throws Exception{
		try {
			Booking b = new Booking("Pablo",4,2,table, "Lunch", 5);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBooking8() throws Exception{
		try {
			Booking b = new Booking("",-4,1,table, "Dinner", -5);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBooking9() throws Exception{
		try {
			Booking b = new Booking("Pablo",4,1,table, "Lunch", 5);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBooking10() throws Exception{
		try {
			Booking b = new Booking("Pablo",-4,-7,table, "Lunch", 0);
			
		}catch(Exception e) {
>>>>>>> master
			e.printStackTrace();
		}
	}

	@Test
	public void testSetGet_name() throws Exception {
		Booking b = new Booking();
		try {
			b.set_name("Pablo");

		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_name(), "Pablo");
	}

	public void testSetGet_name2() throws Exception {
		Booking b = new Booking();
		try {
			b.set_name("");

		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_name(), "");
	}

	@Test
	public void testSetGet_guests() throws Exception {
		Booking b = new Booking();
		try {
<<<<<<< HEAD
			b.set_guests(4);

		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_guests(), 4);
	}

=======
			b.set_name("Pablo");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_name(), "Pablo");
	}
	public void testSetGet_name2() throws Exception{
		Booking b = new Booking();
		try {
			b.set_name("");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_name(), "");
	}
>>>>>>> master
	@Test
	public void testSetGet_guests2() throws Exception {
		Booking b = new Booking();
		try {
<<<<<<< HEAD
			b.set_guests(-4);

		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_guests(), -4);
	}

=======
			b.set_guests(4);
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_guests(), 4);
	}
	@Test
	public void testSetGet_guests2() throws Exception{
		Booking b = new Booking();
		try {
			b.set_guests(-4);
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_guests(), -4);
	}
>>>>>>> master
	@Test
	public void testSetGet_turn() throws Exception {
		Booking b = new Booking();
		try {
			b.set_turn(2);

		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_turn(), 2);
	}

	@Test
<<<<<<< HEAD
	public void testSetGet_turn2() throws Exception {
		Booking b = new Booking();
		try {
			b.set_turn(-7);

		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_turn(), -7);
	}

	@Test
	public void testSetGet_turnLunchDinner() throws Exception {
		Booking b = new Booking();
		try {
			b.set_turnLunchDinner("Lunch");
			;

		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_turnLunchDinner(), "Lunch");
	}

	@Test
	public void testSetGet_turnLunchDinner2() throws Exception {
		Booking b = new Booking();
		try {
			b.set_turnLunchDinner("Dinner");
			;

		} catch (Exception e) {
=======
	public void testSetGet_turn2() throws Exception{
		Booking b = new Booking();
		try {
			b.set_turn(-7);
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_turn(), -7);
	}
	@Test
	public void testSetGet_turnLunchDinner() throws Exception{
		Booking b = new Booking();
		try {
			b.set_turnLunchDinner("Lunch");;
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.get_turnLunchDinner(), "Lunch");
	}
	@Test
	public void testSetGet_turnLunchDinner2() throws Exception{
		Booking b = new Booking();
		try {
			b.set_turnLunchDinner("Dinner");;
			
		}catch(Exception e) {
>>>>>>> master
			assumeNoException(e);
		}
		assertEquals(b.get_turnLunchDinner(), "Dinner");
	}
<<<<<<< HEAD

	@Test
	public void testSetGetidBooking() throws Exception {
		Booking b = new Booking();
		try {
			b.setIdBooking(5);
		} catch (Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.getIdBooking(), 5);
	}

	public void testSetGetidBooking2() throws Exception {
		Booking b = new Booking();
		try {
			b.setIdBooking(-5);
		} catch (Exception e) {
=======
	@Test
	public void testSetGetidBooking() throws Exception{
		Booking b = new Booking();
		try {
			b.setIdBooking(5);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(b.getIdBooking(), 5);
	}
	public void testSetGetidBooking2() throws Exception{
		Booking b = new Booking();
		try {
			b.setIdBooking(-5);
		}catch(Exception e) {
>>>>>>> master
			assumeNoException(e);
		}
		assertEquals(b.getIdBooking(), -5);
	}

}

package org.ControlBookingTable.Domain;

import static org.junit.Assume.assumeNoException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingManagerTest {
	private Table table;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		table = new Table(1, 6, States.UNOCCUPIED, "23/10/19 21:08:00");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCRUDOperations() {
		Booking b1 = null;
		Booking b2 = null;
		try {
			b1 = new Booking("Pablo", 4, 1, table, "lunch", 1);
			b2 = new Booking();
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertTrue(b1.update());

		assertTrue(b2.read());

		assertEquals("lunch", b2.get_turnLunchDinner());

		assertTrue(b1.eliminate());
	}

	@Test
	public void testLastID() {
		Booking b1 = null;
		Booking b2 = null;
		try {
			b1 = new Booking("Pablo", 4, 1, table, "lunch", 10000);
			b2 = new Booking();
		} catch (Exception e) {
			assumeNoException(e);
		}

		assertTrue(b1.insert());
		assertTrue(b2.assignLastId());

		assertEquals(10001, b2.getIdBooking());

		assertTrue(b1.eliminate());
	}

	@Test
	public void testReadAll() {
		Booking b1 = new Booking();
		assertTrue(b1.readAll());
	}

}

package org.Authentication.Domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsersManagerTest {

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
	public void testCRUDUser() throws Exception {
		User u1 = new User("pablo44", "pablo44", "waiter");
		assertTrue(u1.insert());
		u1.setType("room head");
		assertTrue(u1.update());

		User u2 = new User();
		u2.setName("pablo44");
		u2.setPassword("pablo44");
		assertTrue(u2.authenticate());

		assertEquals(u2.getType(), "room head");

		assertTrue(u1.delete());
	}

	@Test
	public void testInsertUser() throws Exception {
		User u1 = new User("G-PLEX", "G-PLEX", "jefe de sala");
		assertFalse(u1.insert());

	}

	@Test
	public void testReadAll() throws Exception {
		User u = new User();
		assertTrue(u.readAll());
		assertNotEquals(0, u.getUserManager().getListaUsuarios().size());

	}

	@Test
	public void testAuthenticate() throws Exception {
		User existentu = new User("G-PLEX", "G-PLEX", "jefe de sala");
		User notexistentu = new User("pablo1", "pablo1", "waiter");
		assertTrue(existentu.authenticate());
		assertFalse(notexistentu.authenticate());

	}

}

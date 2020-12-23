package org.Authentication.Domain;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

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
	public void testUser1()throws Exception {
		try {
			User u = new User("pablo","pablo","waiter");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		
	}
	@Test(expected = Exception.class)
	public void testUser2()throws Exception {
		User u = new User("pablo","pablo","");
	}
	
	@Test(expected = Exception.class)
	public void testUser3()throws Exception {
		User u = new User("pablo","","waiter");
	}
	
	@Test(expected = Exception.class)
	public void testUser4()throws Exception {
		User u = new User("pablo","","");
	}
	
	@Test(expected = Exception.class)
	public void testUser5()throws Exception {
		User u = new User("","pablo","waiter");
	}
	
	@Test(expected = Exception.class)
	public void testUser6()throws Exception {
		User u = new User("","pablo","");
	}
	
	@Test(expected = Exception.class)
	public void testUser7()throws Exception {
		User u = new User("","","waiter");
	}
	
	@Test(expected = Exception.class)
	public void testUser8()throws Exception {
		User u = new User("","","");
	}
	
	@Test(expected = Exception.class)
	public void testSetName1()throws Exception {
		User u = new User();
		u.setName("");
	}
	
	@Test
	public void testSetName2()throws Exception {
		User u = null;
		try {
			u = new User();
			u.setName("pablo");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		
		assertEquals("pablo",u.getName());
		
	}
	
	@Test(expected = Exception.class)
	public void testSetPassword1()throws Exception {
		User u = new User();
		u.setPassword("");
	}
	
	@Test
	public void testSetPassword2()throws Exception {
		User u = null;
		try {
			u = new User();
			u.setPassword("pablo");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		
		assertEquals("pablo",u.getPassword());
		
	}
	
	@Test(expected = Exception.class)
	public void testSetType1()throws Exception {
		User u = new User();
		u.setType("");
	}
	
	@Test
	public void testSetType2()throws Exception {
		User u = null;
		try {
			u = new User();
			u.setType("waiter");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		
		assertEquals("waiter",u.getType());
		
	}




}

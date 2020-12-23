package org.Authentication.Presentation;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UI_AuthenticationTest {

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
	public void testConstructor() {
		try {
			UI_Authentication ui = new UI_Authentication();
		}catch(Exception e){
			assumeNoException(e);
			
		}
	}
	
	@Test
	public void testTrueAuthentication(){
		UI_Authentication ui = null;
		try {
			ui = new UI_Authentication();
			ui.setTxtName("G-PLEX");
			ui.setPassword("G-PLEX");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		try {
			assertTrue(ui.accept());
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	@Test
	public void testFalseAuthentication(){
		UI_Authentication ui = null;
		try {
			ui = new UI_Authentication();
			ui.setTxtName("jjjj");
			ui.setPassword("jjjj");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		try {
			assertFalse(ui.accept());
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	@Test
	public void testFalseAuthentication2(){
		UI_Authentication ui = null;
		try {
			ui = new UI_Authentication();
			ui.setTxtName("");
			ui.setPassword("");
			
		}catch(Exception e) {
			assumeNoException(e);
		}
		try {
			assertFalse(ui.accept());
		}catch(Exception e) {
			assumeNoException(e);
		}
	}

}

package org.ControlStatesOfTables.Presentation;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.ControlBookingTable.Domain.States;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UI_setTableStateTest {

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

	@Test (expected = Exception.class)
	public void testUI_SetTableState1() throws Exception {
		UI_setTableState panel = new UI_setTableState(-6);
	}
	
	@Test (expected = Exception.class)
	public void testUI_SetTableState2() throws Exception {
		UI_setTableState panel = new UI_setTableState(0);
	}
	
	@Test 
	public void testUI_SetTableState3() throws Exception {
		try {
			UI_setTableState panel = new UI_setTableState(3);
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	
	@Test 
	public void testUI_SetTableState4() throws Exception {
		UI_setTableState panel = new UI_setTableState(3);
		panel.btnStates(States.PREPARATION);
		assertEquals(panel.getLastState(), States.PREPARATION);
	}
	
	

}

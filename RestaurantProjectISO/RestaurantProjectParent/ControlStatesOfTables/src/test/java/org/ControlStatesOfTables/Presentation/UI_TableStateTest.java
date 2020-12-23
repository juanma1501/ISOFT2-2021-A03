package org.ControlStatesOfTables.Presentation;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UI_TableStateTest {

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
	public void test_UI_TableState() {
		UI_TableState window = null;
		try {
			window = new UI_TableState();
			window.reload();
		} catch (Exception e) {
			assumeNoException(e);
		}
	}

}

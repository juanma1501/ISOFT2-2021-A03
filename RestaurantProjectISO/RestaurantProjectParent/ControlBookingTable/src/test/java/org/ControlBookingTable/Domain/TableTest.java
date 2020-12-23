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

	@Test(expected = Exception.class)
	public void testNewTable() {
		try {
			Table table = new Table(-20,-6,States.UNOCCUPIED, "23/10/18 23:00:00");
		}catch(Exception e) {
			assumeNoException(e);
		}
	}
	@Test(expected = Exception.class)
	public void testNewTable2() throws Exception {
			Table table = new Table(20,6,States.UNOCCUPIED, "32/10/18 23:00:00");
	}
	@Test(expected = Exception.class)
	public void testNewTable3() throws Exception {
			Table table = new Table(0,0,States.UNOCCUPIED, "23/10/18 23:00:00");
	}
	@Test(expected = Exception.class)
	public void testNewTable4() throws Exception {
			Table table = new Table(-20,6,States.UNOCCUPIED, "32/10/18 23:00:61");
	}
	@Test(expected = Exception.class)
	public void testNewTable5() throws Exception {
			Table table = new Table(20,0,States.UNOCCUPIED, "32/10/18 23:00:00");
	}
	@Test(expected = Exception.class)
	public void testNewTable6() throws Exception {
			Table table = new Table(0,-6,States.UNOCCUPIED, "32/10/18 23:00:00");
	}
	@Test(expected = Exception.class)
	public void testNewTable7() throws Exception {
			Table table = new Table(0,6,States.UNOCCUPIED, "23/10/18 23:00:61");
	}
	@Test(expected = Exception.class)
	public void testNewTable8() throws Exception {
			Table table = new Table(20,-6,States.UNOCCUPIED, "32/10/18 23:00:00");
	}
	@Test(expected = Exception.class)
	public void testNewTable9() throws Exception {
			Table table = new Table(-20,0,States.UNOCCUPIED, "23/10/18 23:00:00");
	}
	@Test
	public void testNewTable10() throws Exception {
			Table table = new Table(20,6,States.UNOCCUPIED, "23/10/18 23:00:00");
	}
	@Test
	public void testSetIdTable() throws Exception{
		Table t = new Table();
		try {
			t.setIdTable(20);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(20,t.getIdTable());
	}
	@Test(expected = Exception.class)
	public void testSetIdTable2() throws Exception{
		Table t = new Table();
		try {
			t.setIdTable(-20);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(-20,t.getIdTable());
	}
	@Test
	public void testSetClients() throws Exception{
		Table t = new Table();
		try {
			t.setClients(6);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(6,t.getClients());
	}
	@Test
	public void testSetClients2() throws Exception{
		Table t = new Table();
		try {
			t.setClients(-6);
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals(-6,t.getClients());
	}
	
	@Test
	public void testSetStateTime() throws Exception{
		Table t=new Table();
		try{
			t.setStateTime("23/10/18 23:00:00");
		}catch(Exception e) {
			assumeNoException(e);
		}
		assertEquals("23/10/18 23:00:00",t.getStateTime());
	}
	@Test(expected=Exception.class)
	public void testSetStateTime2()throws Exception{
		Table t=new Table();
		t.setStateTime("32/10/18 23:00:00");
	}
	@Test(expected=Exception.class)
	public void testSetStateTime3()throws Exception{
		Table t=new Table();
		t.setStateTime("23/10/18 23:00:61");
	}
	@Test(expected=Exception.class)
	public void testSetStateTime4()throws Exception{
		Table t=new Table();
		t.setStateTime("32/10/18 23:00:61");
	}
	}
package org.Domain;

import org.Domain.Table;

public class Booking {
	private String _name;
	private int _guests;
	private int _turn;
	private Table table;
	private String _turnLunchDinner;
	private int idBooking;

	private BookingManager bookingManager;

	public Booking(String _name, int _guests, int _turn, Table table, String _turnLunchDinner, int idBooking) {
		set_name(_name);
		set_guests(_guests);
		set_turn(_turn);
		setTable(table);
		set_turnLunchDinner(_turnLunchDinner);
		setIdBooking(idBooking);
		this.bookingManager = new BookingManager();
	}

	public Booking() {
		this.bookingManager = new BookingManager();
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public int get_guests() {
		return _guests;
	}

	public BookingManager getBookingManager() {
		return this.bookingManager;
	}

	public void set_guests(int _guests) {
		this._guests = _guests;
	}

	public int get_turn() {
		return _turn;
	}

	public void set_turn(int _turn) {
		this._turn = _turn;
	}

	public String get_turnLunchDinner() {
		return _turnLunchDinner;
	}

	public void set_turnLunchDinner(String _turnLunchDinner) {
		this._turnLunchDinner = _turnLunchDinner;
	}

	public int getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}

	public boolean update() {
		return this.bookingManager.update(this);
	}

	public boolean read() {
		return this.bookingManager.read(this);
	}

	public boolean readAll() {
		return this.bookingManager.readAll();
	}

	public boolean eliminate() {
		return this.bookingManager.delete(this);
	}

	public boolean insert() {
		return this.bookingManager.insert(this);
	}

	public boolean assignLastId() {
		return this.bookingManager.lastID(this);
	}

}
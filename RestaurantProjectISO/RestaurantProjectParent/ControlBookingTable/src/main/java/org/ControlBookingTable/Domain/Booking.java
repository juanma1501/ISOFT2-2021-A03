package org.ControlBookingTable.Domain;

import org.ControlBookingTable.Domain.Table;

/**
 * The Class Booking.
 */
public class Booking {
	
	/** The name. */
	private String _name;
	
	/** The guests. */
	private int _guests;
	
	/** The turn. */
	private int _turn;
	
	/** The table. */
	private Table table;
	
	/** The turn lunch dinner. */
	private String _turnLunchDinner;
	
	/** The id booking. */
	private int idBooking;

	/** The booking manager. */
	private BookingManager bookingManager;

	/**
	 * Instantiates a new booking.
	 *
	 * @param _name the name
	 * @param _guests the guests
	 * @param _turn the turn
	 * @param table the table
	 * @param _turnLunchDinner the turn lunch dinner
	 * @param idBooking the id booking
	 */
	public Booking(String _name, int _guests, int _turn, Table table, String _turnLunchDinner, int idBooking) {
		set_name(_name);
		set_guests(_guests);
		set_turn(_turn);
		setTable(table);
		set_turnLunchDinner(_turnLunchDinner);
		setIdBooking(idBooking);
		this.bookingManager = new BookingManager();
	}

	/**
	 * Instantiates a new booking.
	 */
	public Booking() {
		this.bookingManager = new BookingManager();
	}

	/**
	 * Gets the table.
	 *
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * Sets the table.
	 *
	 * @param table the new table
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String get_name() {
		return _name;
	}

	/**
	 * Sets the name.
	 *
	 * @param _name the new name
	 */
	public void set_name(String _name) {
		this._name = _name;
	}

	/**
	 * Gets the guests.
	 *
	 * @return the guests
	 */
	public int get_guests() {
		return _guests;
	}

	/**
	 * Gets the booking manager.
	 *
	 * @return the booking manager
	 */
	public BookingManager getBookingManager() {
		return this.bookingManager;
	}

	/**
	 * Sets the guests.
	 *
	 * @param _guests the new guests
	 */
	public void set_guests(int _guests) {
		this._guests = _guests;
	}

	/**
	 * Gets the turn.
	 *
	 * @return the turn
	 */
	public int get_turn() {
		return _turn;
	}

	/**
	 * Sets the turn.
	 *
	 * @param _turn the new turn
	 */
	public void set_turn(int _turn) {
		this._turn = _turn;
	}

	/**
	 * Gets the turn lunch dinner.
	 *
	 * @return the turn lunch dinner
	 */
	public String get_turnLunchDinner() {
		return _turnLunchDinner;
	}

	/**
	 * Sets the turn lunch dinner.
	 *
	 * @param _turnLunchDinner the new turn lunch dinner
	 */
	public void set_turnLunchDinner(String _turnLunchDinner) {
		this._turnLunchDinner = _turnLunchDinner;
	}

	/**
	 * Gets the id booking.
	 *
	 * @return the id booking
	 */
	public int getIdBooking() {
		return idBooking;
	}

	/**
	 * Sets the id booking.
	 *
	 * @param idBooking the new id booking
	 */
	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}

	/**
	 * Update.
	 *
	 * @return true, if successful
	 */
	public boolean update() {
		return this.bookingManager.update(this);
	}

	/**
	 * Read.
	 *
	 * @return true, if successful
	 */
	public boolean read() {
		return this.bookingManager.read(this);
	}

	/**
	 * Read all.
	 *
	 * @return true, if successful
	 */
	public boolean readAll() {
		return this.bookingManager.readAll();
	}

	/**
	 * Eliminate.
	 *
	 * @return true, if successful
	 */
	public boolean eliminate() {
		return this.bookingManager.delete(this);
	}

	/**
	 * Insert.
	 *
	 * @return true, if successful
	 */
	public boolean insert() {
		return this.bookingManager.insert(this);
	}

	/**
	 * Assign last id.
	 *
	 * @return true, if successful
	 */
	public boolean assignLastId() {
		return this.bookingManager.lastID(this);
	}

}
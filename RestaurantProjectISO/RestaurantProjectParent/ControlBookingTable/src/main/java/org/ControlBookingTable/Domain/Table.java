package org.ControlBookingTable.Domain;

import java.text.SimpleDateFormat;

import com.google.protobuf.TextFormat.ParseException;

/**
 * The Class Table.
 */
public class Table {
	
	/** The id table. */
	private int _idTable;
	
	/** The clients. */
	private int _clients;
	
	/** The state. */
	private States _state;
	
	/** The state time. */
	private String _stateTime;

	/** The tables manager. */
	private TablesManager tablesManager;

	/**
	 * Instantiates a new table.
	 *
	 * @param aIdTable the a id table
	 * @param aClients the a clients
	 * @param aState the a state
	 * @param aStateTime the a state time
	 * @throws Exception the exception
	 */
	public Table(int aIdTable, int aClients, States aState, String aStateTime) throws Exception {

		if (aIdTable < 1) {
			throw new Exception("The id of the table must be a positive integer.");
		}

		if (aClients < 1) {
			throw new Exception("The number of guests must be a positive integer.");
		}

		SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		date_formatter.setLenient(false);
		date_formatter.parse(aStateTime);

		setIdTable(aIdTable);
		setClients(aClients);
		setState(aState);
		setStateTime(aStateTime);
		this.tablesManager = new TablesManager();
	}

	/**
	 * Instantiates a new table.
	 */
	public Table() {
		this.tablesManager = new TablesManager();
	}

	/**
	 * Delete.
	 *
	 * @return true, if successful
	 */
	public boolean delete() {
		return this.tablesManager.delete(this);
	}

	/**
	 * Insert.
	 *
	 * @return true, if successful
	 */
	public boolean insert() {
		return this.tablesManager.insert(this);
	}

	/**
	 * Update.
	 *
	 * @return true, if successful
	 */
	public boolean update() {
		return this.tablesManager.update(this);
	}

	/**
	 * Read.
	 *
	 * @return true, if successful
	 */
	public boolean read() {
		return this.tablesManager.read(this);
	}

	/**
	 * Read all.
	 *
	 * @return true, if successful
	 */
	public boolean readAll() {
		return this.tablesManager.readAll();
	}

	/**
	 * Sets the id table.
	 *
	 * @param aIdTable the new id table
	 * @throws Exception the exception
	 */
	public void setIdTable(int aIdTable) throws Exception {
		if (aIdTable < 1) {
			throw new Exception("The id of the table must be a positive integer.");
		}
		this._idTable = aIdTable;
	}

	/**
	 * Gets the id table.
	 *
	 * @return the id table
	 */
	public int getIdTable() {
		return this._idTable;
	}

	/**
	 * Sets the clients.
	 *
	 * @param aClients the new clients
	 */
	public void setClients(int aClients) {
		this._clients = aClients;
	}

	/**
	 * Gets the clients.
	 *
	 * @return the clients
	 */
	public int getClients() {
		return this._clients;
	}

	/**
	 * Sets the state.
	 *
	 * @param aState the new state
	 */
	public void setState(States aState) {
		this._state = aState;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public States getState() {
		return this._state;
	}

	/**
	 * Gets the state time.
	 *
	 * @return the state time
	 */
	public String getStateTime() {
		return this._stateTime;
	}

	/**
	 * Sets the state time.
	 *
	 * @param aStateTime the new state time
	 * @throws ParseException the parse exception
	 * @throws ParseException the parse exception
	 */
	public void setStateTime(String aStateTime) throws ParseException, java.text.ParseException {
		SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		date_formatter.setLenient(false);
		date_formatter.parse(aStateTime);
		this._stateTime = aStateTime;
	}

	/**
	 * Gets the tables manager.
	 *
	 * @return the tables manager
	 */
	public TablesManager getTablesManager() {
		return tablesManager;
	}

	/**
	 * Sets the tables manager.
	 *
	 * @param tablesManager the new tables manager
	 */
	public void setTablesManager(TablesManager tablesManager) {
		this.tablesManager = tablesManager;
	}
}
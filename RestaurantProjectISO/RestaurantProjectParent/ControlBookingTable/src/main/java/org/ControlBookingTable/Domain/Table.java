package org.ControlBookingTable.Domain;

import java.text.SimpleDateFormat;

import com.google.protobuf.TextFormat.ParseException;

public class Table {
	private int _idTable;
	private int _clients;
	private States _state;
	private String _stateTime;

	private TablesManager tablesManager;

	public Table(int aIdTable, int aClients, States aState, String aStateTime) throws Exception {

		if (aIdTable < 1) {
			throw new Exception("The id of the table must be a positive integer.");
		}

		if (aClients < 1) {
			throw new Exception("The number of guests must be a positive integer.");
		}

		SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		date_formatter.setLenient(false);
		date_formatter.parse(_stateTime);

		setIdTable(aIdTable);
		setClients(aClients);
		setState(aState);
		setStateTime(aStateTime);
		this.tablesManager = new TablesManager();
	}

	public Table() {
		this.tablesManager = new TablesManager();
	}

	public boolean delete() {
		return this.tablesManager.delete(this);
	}

	public boolean insert() {
		return this.tablesManager.insert(this);
	}

	public boolean update() {
		return this.tablesManager.update(this);
	}

	public boolean read() {
		return this.tablesManager.read(this);
	}

	public boolean readAll() {
		return this.tablesManager.readAll();
	}

	public void setIdTable(int aIdTable) throws Exception {
		if (aIdTable < 1) {
			throw new Exception("The id of the table must be a positive integer.");
		}
		this._idTable = aIdTable;
	}

	public int getIdTable() {
		return this._idTable;
	}

	public void setClients(int aClients) {
		this._clients = aClients;
	}

	public int getClients() {
		return this._clients;
	}

	public void setState(States aState) {
		this._state = aState;
	}

	public States getState() {
		return this._state;
	}

	public String getStateTime() {
		return this._stateTime;
	}

	public void setStateTime(String aStateTime) throws ParseException, java.text.ParseException {
		SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		date_formatter.setLenient(false);
		date_formatter.parse(this._stateTime);
		this._stateTime = aStateTime;
	}

	public TablesManager getTablesManager() {
		return tablesManager;
	}

	public void setTablesManager(TablesManager tablesManager) {
		this.tablesManager = tablesManager;
	}
}
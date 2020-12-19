package org.ControlBookingTable.Domain;

public class Table {
	private int _idTable;
	private int _clients;
	private States _state;

	private TablesManager tablesManager;

	public Table(int aIdTable, int aClients, States aState) {
		setIdTable(aIdTable);
		setClients(aClients);
		setState(aState);
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

	public void setIdTable(int aIdTable) {
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

	public TablesManager getTablesManager() {
		return tablesManager;
	}

	public void setTablesManager(TablesManager tablesManager) {
		this.tablesManager = tablesManager;
	}
}
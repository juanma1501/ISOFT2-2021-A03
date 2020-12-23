package org.ControlBookingTable.Domain;

import org.ControlBookingTable.Persistency.Broker;

import java.sql.*;
import java.util.ArrayList;

/**
 * The Class TablesManager.
 */
public class TablesManager {
	
	/** The tables list. */
	private ArrayList<Table> _tablesList;

	/**
	 * Instantiates a new tables manager.
	 */
	public TablesManager() {
		this._tablesList = new ArrayList<Table>();
	}

	/**
	 * Sets the tables list.
	 *
	 * @param _tablesList the new tables list
	 */
	public void set_tablesList(ArrayList<Table> _tablesList) {
		this._tablesList = _tablesList;
	}

	/**
	 * Gets the tables list.
	 *
	 * @return the tables list
	 */
	public ArrayList<Table> get_tablesList() {
		return _tablesList;
	}

	/**
	 * Delete.
	 *
	 * @param aTable the a table
	 * @return true, if successful
	 */
	public boolean delete(Table aTable) {
		boolean done = false;
		try {
			Broker.getInstance().update("DELETE FROM mesas WHERE idMesa = " + aTable.getIdTable() + ";");
			done = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}

	/**
	 * Update.
	 *
	 * @param aTable the a table
	 * @return true, if successful
	 */
	public boolean update(Table aTable) {
		boolean done = false;
		try {
			Broker.getInstance()
					.update("UPDATE mesas SET comensales=" + aTable.getClients() + ", " + "estado='" + aTable.getState()
							+ "', horaEstado='" + aTable.getStateTime() + "' WHERE idMesa = " + aTable.getIdTable()
							+ ";");
			done = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}

	/**
	 * Insert.
	 *
	 * @param aTable the a table
	 * @return true, if successful
	 */
	public boolean insert(Table aTable) {
		boolean done = false;
		try {
			Broker.getInstance().update("INSERT INTO mesas VALUES(" + aTable.getIdTable() + "," + aTable.getClients()
					+ ",'" + aTable.getState() + "','" + aTable.getStateTime() + "');");
			done = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}

	/**
	 * Read.
	 *
	 * @param aTable the a table
	 * @return true, if successful
	 */
	public boolean read(Table aTable) {
		boolean done = false;
		ResultSet result;
		try {
			result = Broker.getInstance().read("SELECT * FROM mesas WHERE idmesa=" + aTable.getIdTable() + ";");
			while (result.next()) {
				aTable.setClients(result.getInt(2));
				States state = States.valueOf(result.getString(3));
				aTable.setState(state);
				aTable.setStateTime(result.getString(4));
				done = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return done;
	}

	/**
	 * Read all.
	 *
	 * @return true, if successful
	 */
	public boolean readAll() {
		boolean done = false;
		ResultSet result;
		try {
			result = Broker.getInstance().read("SELECT * FROM mesas ORDER BY idMesa");
			Table table;
			while (result.next()) {

				States state = States.valueOf(result.getString(3));
				table = new Table(result.getInt(1), result.getInt(2), state, result.getString(4));
				this._tablesList.add(table);
				done = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return done;
	}

}

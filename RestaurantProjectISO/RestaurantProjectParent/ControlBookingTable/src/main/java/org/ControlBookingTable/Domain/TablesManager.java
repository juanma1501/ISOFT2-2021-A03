package org.ControlBookingTable.Domain;

import org.ControlBookingTable.Persistency.Broker;

import java.sql.*;
import java.util.ArrayList;

public class TablesManager {
	private ArrayList<Table> _tablesList;

	public TablesManager() {
		this._tablesList = new ArrayList<Table>();
	}

	public void set_tablesList(ArrayList<Table> _tablesList) {
		this._tablesList = _tablesList;
	}

	public ArrayList<Table> get_tablesList() {
		return _tablesList;
	}

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

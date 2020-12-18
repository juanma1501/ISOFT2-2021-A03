package org.Domain;

import org.Persistency.Broker;

import java.sql.*;
import java.util.ArrayList;

public class BookingManager {
	private ArrayList<Booking> _bookingList;

	public BookingManager() {
		this._bookingList = new ArrayList<Booking>();
	}

	public ArrayList<Booking> getListBooking() {
		return this._bookingList;
	}

	public boolean delete(Booking aBooking) {
		boolean done = false;
		try {
			Broker.getInstance().update("DELETE FROM reserva WHERE idReserva = " + aBooking.getIdBooking() + "");
			done = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}

	public boolean update(Booking aBooking) {
		boolean done = false;
		try {
			Broker.getInstance()
					.update("UPDATE reserva SET nombrecliente='" + aBooking.get_name() + "', " + "comensales="
							+ aBooking.get_guests() + ", turnocomcen ='" + aBooking.get_turnLunchDinner() + "'"
							+ ", turno=" + aBooking.get_turn() + ", idMesa=" + aBooking.getTable().getIdTable()
							+ " WHERE idReserva = " + aBooking.getIdBooking() + "");
			done = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}

	public boolean insert(Booking aBooking) {
		boolean done = false;
		try {
			Broker.getInstance()
					.update("INSERT INTO reserva" + "VALUES(" + aBooking.getIdBooking() + ",'" + aBooking.get_name()
							+ "'," + aBooking.get_guests() + ",'" + aBooking.get_turnLunchDinner() + "',"
							+ aBooking.get_turn() + "," + aBooking.getTable().getIdTable() + ")");
			done = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}

	public boolean read(Booking aBooking) {
		ResultSet result;
		boolean done = false;
		try {
			result = Broker.getInstance().read("SELECT * FROM reserva WHERE idReserva=" + aBooking.getIdBooking() + "");
			while (result.next()) {
				aBooking.set_name(result.getString(2));
				aBooking.set_guests(result.getInt(3));
				aBooking.set_turnLunchDinner(result.getString(4));
				aBooking.set_turn(result.getInt(5));
				Table table = new Table();
				table.setIdTable(result.getInt(6));
				table.read();
				aBooking.setTable(table);
				done = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}

	public boolean readAll() {
		ResultSet result;
		boolean done = false;
		try {
			result = Broker.getInstance().read("SELECT * FROM\r\n" + "reserva ORDER BY idReserva");
			Booking booking;
			while (result.next()) {
				Table table = new Table();
				table.setIdTable(result.getInt(6));
				booking = new Booking(result.getString(2), result.getInt(3), result.getInt(5), table,
						result.getString(4), result.getInt(1));
				this._bookingList.add(booking);
				done = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}

	public boolean lastID(Booking aBooking) {
		ResultSet result;
		boolean done = false;
		try {
			result = Broker.getInstance().read("SELECT MAX(idReserva) FROM reserva");
			while (result.next()) {
				aBooking.setIdBooking(result.getInt(1) + 1);
				done = true;
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Gnereal Exception");
			e.printStackTrace();
		}
		return done;
	}
}
package org.Authentication.Domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.ControlBookingTable.Persistency.Broker;

/**
 * The Class UsersManager.
 */
public class UsersManager {

	/** The user list. */
	private ArrayList<User> _userList;

	/**
	 * Instantiates a new users manager.
	 */
	public UsersManager() {
		this._userList = new ArrayList<User>();
	}

	/**
	 * Gets the lista usuarios.
	 *
	 * @return the lista usuarios
	 */
	public ArrayList<User> getListaUsuarios() {
		return this._userList;
	}

	/**
	 * Delete.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean delete(User user) {
		boolean isCorrect = false;
		try {
			Broker.getInstance().update("DELETE FROM usuarios WHERE nombre = '" + user.getName() + "'");
			isCorrect = true;
		} catch (SQLException e) {
			isCorrect = false;
		} catch (Exception e) {
			isCorrect = false;
		}
		return isCorrect;
	}

	/**
	 * Update.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean update(User user) {
		boolean isCorrect = false;
		try {
			String SQL = "UPDATE usuarios SET nombre='" + user.getName() + "', " + "pass='" + user.getPassword()
					+ "',tipo='" + user.getType() + "'" + " WHERE nombre = '" + user.getName() + "' AND pass='"
					+ user.getPassword() + "'";
			Broker.getInstance().update(SQL);
			isCorrect = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			isCorrect = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			isCorrect = false;
		}
		return isCorrect;
	}

	/**
	 * Insert.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean insert(User user) {
		boolean isCorrect = false;
		try {
			Broker.getInstance().update("INSERT INTO usuarios VALUES ('" + user.getName() + "'," + "'"
					+ user.getPassword() + "','" + user.getType() + "')");
			isCorrect = true;
		} catch (SQLException e) {
			isCorrect = false;
		} catch (Exception e) {
			isCorrect = false;
		}
		return isCorrect;
	}

	/**
	 * Login.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean login(User user) {
		ResultSet result;
		boolean exists = false;
		try {
			result = Broker.getInstance().read("SELECT * FROM usuarios WHERE nombre='" + user.getName() + "'"
					+ " AND pass='" + user.getPassword() + "'");

			while (result.next()) {
				exists = true;
				user.setName(result.getString(1));
				user.setPassword(result.getString(2));
				user.setType(result.getString(3));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			exists = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			exists = false;
		}
		return exists;
	}

	/**
	 * Read all.
	 *
	 * @return true, if successful
	 */
	public boolean readAll() {
		ResultSet result;
		boolean isCorrect = false;
		try {
			result = Broker.getInstance().read("SELECT * FROM usuarios");
			User user;

			while (result.next()) {
				isCorrect = true;
				user = new User(result.getString(1), result.getString(2), result.getString(3));
				_userList.add(user);
			}
		} catch (SQLException e) {
			isCorrect = false;
		} catch (Exception e) {
			isCorrect = false;
		}
		return isCorrect;
	}

}
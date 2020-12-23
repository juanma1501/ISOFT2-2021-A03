package org.ControlBookingTable.Persistency;

import java.sql.*;

/**
 * The Class Broker.
 */
public class Broker {
	
	/** The instance. */
	private static Broker _instance = null;
	
	/** The m BD. */
	protected static java.sql.Connection mBD;
	
	/** The url. */
	private static String url = "jdbc:mysql://172.20.48.70:3306/A03dbservice?user=A03&password=@ISoft2.2020#";
	
	/** The driver. */
	private static String driver = "com.mysql.cj.jdbc.Driver";

	/**
	 * Gets the single instance of Broker.
	 *
	 * @return single instance of Broker
	 * @throws Exception the exception
	 */
	public static Broker getInstance() throws Exception {
		if (_instance == null) {
			_instance = new Broker();
		}
		return _instance;
	}

	/**
	 * Instantiates a new broker.
	 *
	 * @throws Exception the exception
	 */
	private Broker() throws Exception {
		connect();
	}

	/**
	 * Connect.
	 *
	 * @throws Exception the exception
	 */
	private void connect() throws Exception {
		Class.forName(driver);
		mBD = DriverManager.getConnection(url, "A03", "@ISoft2.2020#");
		;
	}

	/**
	 * Desconectar.
	 *
	 * @throws Exception the exception
	 */
	public void desconectar() throws Exception {
		mBD.close();
	}

	/**
	 * Update.
	 *
	 * @param SQL the sql
	 * @return the int
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public int update(String SQL) throws SQLException, Exception {
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		return res;
	}

	/**
	 * Read.
	 *
	 * @param SQL the sql
	 * @return the result set
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public ResultSet read(String SQL) throws SQLException, Exception {
		connect();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		return resultado;
	}
}
package org.ControlBookingTable.Persistency;

import java.sql.*;

public class Broker {
	private static Broker _instance = null;
	protected static java.sql.Connection mBD;
	private static String url = "jdbc:mysql://172.20.48.70:3306/A03dbservice?user=A03&password=@ISoft2.2020#";
	private static String driver = "com.mysql.cj.jdbc.Driver";

	public static Broker getInstance() throws Exception {
		if (_instance == null) {
			_instance = new Broker();
		}
		return _instance;
	}

	private Broker() throws Exception {
		connect();
	}

	private void connect() throws Exception {
		Class.forName(driver);
		mBD = DriverManager.getConnection(url, "A03", "@ISoft2.2020#");
		;
	}

	public void desconectar() throws Exception {
		mBD.close();
	}

	public int update(String SQL) throws SQLException, Exception {
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	public ResultSet read(String SQL) throws SQLException, Exception {
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		ResultSet resultado = stmt.executeQuery(SQL);
		return resultado;
	}
}
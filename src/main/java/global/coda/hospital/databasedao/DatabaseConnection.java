package global.coda.hospital.databasedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class DatabaseConnection {
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("sqlqueries",
			Locale.getDefault());
	public static  Connection connection = null;

	/*
	 * creates connection to sql db and returns connection object
	 */
	public static Connection createconnection()   {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");

			// create connection
			String connectionUrl = LOCAL_MESSAGES_BUNDLE.getString(HospitalQueries.connection);
			connection = DriverManager.getConnection(connectionUrl);
			return connection;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	/*
	 * closes connection
	 */
	public void CloseConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package connection;

import static com.google.common.base.Preconditions.checkNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	/* ========== Public ========== */
	public DatabaseConnector() {

		try {
			Class.forName(DatabaseConnector.DRIVER);
			connection = DriverManager.getConnection(DB_URL);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika JDBC");
			e.printStackTrace();
		}

		try {
		} catch (SQLException e) {
			System.err.println("Problem z otwarciem polaczenia");
			e.printStackTrace();
		}

	}

	/**
	 * Retrieves the connection
	 * @return
	 */
	public Connection getConnection() {
		checkNotNull(connection);
		return connection;
	}

	/* ========== Private ========== */
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String DB_URL = "jdbc:sqlite:biblioteka.db";

	private Connection connection;

}

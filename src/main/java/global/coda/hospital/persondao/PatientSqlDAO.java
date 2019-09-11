package global.coda.hospital.persondao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.persondao.PersonDAOPatternSql;

public class PatientSqlDAO extends PersonDAOPatternSql {
	public PatientSqlDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
			Locale.getDefault());
	private static final Logger LOGGER = LogManager.getLogger(PatientSqlDAO.class);

	public boolean createPatient(PatientRecord record) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionUrl = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&user=root&password=root";
		Connection conn = DriverManager.getConnection(connectionUrl);
		String createquery = "INSERT INTO t_user (user_name,user_password,user_location,user_age,user_phone,fk_role_id)"
				+ " values (?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = conn.prepareStatement(createquery);
		preparedStatement.setString(1, record.getName());
		preparedStatement.setString(2, record.getPassword());
		preparedStatement.setString(3, record.getLocation());
		preparedStatement.setInt(4, Integer.parseInt(record.getAge()));
		preparedStatement.setString(5, record.getPhone());
		preparedStatement.setInt(6, 1);
		preparedStatement.execute();
		conn.close();
		return true;
		
	}
	public boolean updatePatient(String username) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String connectionUrl = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&user=root&password=root";
		Connection conn = DriverManager.getConnection(connectionUrl);
		String createquery = "UPDATE t_user SET user_password,user_location,user_age,user_phone,fk_role_id)"
				+ " values (?, ?, ?, ?, ?, ?)";
		return true;
	}
	public boolean checkUser(String username) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionUrl = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&user=root&password=root";
		Connection conn = DriverManager.getConnection(connectionUrl);
		String query="SELECT * FROM t_user WHERE user_name = '"+username+"'";
		ResultSet rs = conn.prepareStatement(query).executeQuery();
		int rowcount = rs.last() ? rs.getRow() : 0;
		if(rowcount>=1) {
			return true;
		}
		return false;
	}
}

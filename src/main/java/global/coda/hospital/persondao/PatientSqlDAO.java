package global.coda.hospital.persondao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.bean.PatientRecord;
import global.coda.hospital.hospitaldao.DatabaseConnection;

public class PatientSqlDAO {
	public PatientSqlDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
Connection connection=DatabaseConnection.connection;
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("patient",
			Locale.getDefault());
	private static final Logger LOGGER = LogManager.getLogger(PatientSqlDAO.class);

	public boolean createPatient(PatientRecord record) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		int patientkey=0;
		String connectionUrl = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&user=root&password=root";
		Connection conn = DriverManager.getConnection(connectionUrl);
		String createquery = "INSERT INTO t_user (user_name,user_password,user_location,user_age,user_phone,fk_role_id)"
				+ " values (?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = conn.prepareStatement(createquery,Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, record.getName());
		preparedStatement.setString(2, record.getPassword());
		preparedStatement.setString(3, record.getLocation());
		preparedStatement.setInt(4, Integer.parseInt(record.getAge()));
		preparedStatement.setString(5, record.getPhone());
		preparedStatement.setInt(6, 1);
		preparedStatement.execute();
		ResultSet resultset= preparedStatement.getGeneratedKeys();
		if(resultset.next()) {
			patientkey=resultset.getInt(1);
		}
		
		conn.close();
		return true;
		
	}
	
	
    public boolean updatePatient(String patientQuery, int patientUserId, String newPatientValue) {
        
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(patientQuery);
            statement.setString(1, newPatientValue);
            statement.setInt(2, patientUserId);
            result = statement.executeUpdate();
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        if (result > 0) {
            return true;
        }
        return false;
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
	  public boolean viewUserDetails(String patientQuery, int branchId) {
	       
	        boolean result = false;
	        try {
	            PreparedStatement statement = connection.prepareStatement(patientQuery);
	            statement.setInt(1, branchId);
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                result = true;
	                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(PatientConstants.DOCNAME) + resultSet.getString(1));
	                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(PatientConstants.DOCSPE) + resultSet.getString(2));
	                LOGGER.debug(LOCAL_MESSAGES_BUNDLE.getString(PatientConstants.DOCLOC) + resultSet.getString(3));
	            }
	            
	        } catch (Exception exception) {
	            LOGGER.error(exception.getMessage());
	        }
	        return result;
	    }
	}


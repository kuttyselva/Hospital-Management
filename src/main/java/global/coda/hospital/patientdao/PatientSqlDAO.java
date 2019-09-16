package global.coda.hospital.patientdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import global.coda.hospital.bean.PatientRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hospital.databasedao.DatabaseConnection;

public class PatientSqlDAO {
	public PatientSqlDAO()  {
		super();
		// TODO Auto-generated constructor stub
	}
public Connection connection=new DatabaseConnection().createconnection();
	public static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("patient",
			Locale.getDefault());
	private static final Logger LOGGER = LogManager.getLogger(PatientSqlDAO.class);

	public boolean createPatientRecord(List<String> query, PatientRecord record) {
		int result = 0;
		int userid = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(query.get(0), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, record.getName());
			statement.setString(2, record.getPassword());
			statement.setString(3, record.getLocation());
			statement.setString(4, record.getAge());
			statement.setString(5, record.getPhone());
			statement.setInt(6, 1);
			result = statement.executeUpdate();
			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.next()) {
				userid = resultset.getInt(1);
			}
			statement = connection.prepareStatement(query.get(1));
			statement.setString(1, record.getDisease());
			statement.setInt(2, userid);
			result = statement.executeUpdate();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		}
		if (result > 0) {
			return true;
		}
		return false;
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
	
	

	  public boolean viewUserDetails(String patientQuery, String branchname) {
	       
	        boolean result = false;
	        try {
	            PreparedStatement statement = connection.prepareStatement(patientQuery);
	            statement.setString(1, branchname);
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

